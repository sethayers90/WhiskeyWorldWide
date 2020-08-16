package com.whiskeyworldwide.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whiskeyworldwide.model.Products;
import com.whiskeyworldwide.model.User;
import com.whiskeyworldwide.services.UserService;
import com.whiskeyworldwide.utils.DataValidation;
import com.whiskeyworldwide.utils.States;
import com.whiskeyworldwide.utils.WebUtils;

@Controller
@SessionAttributes({ "loggedInuser", "role" })
public class AccountController {

	@Autowired
	private UserService userService;
	// private UserRepository userRepository;

	@Autowired
	private WebUtils webUtils;

	@Autowired
	private DataValidation dataValidation;

	/*
	 * User user = new User();
	 * 
	 * @GetMapping("profile") String profile(@SessionAttribute(required = false)
	 * String loggedInuser, Model model) {
	 * 
	 * try { if (loggedInuser.isEmpty() && loggedInuser != null) {
	 * model.addAttribute("error", "Expired session, please Login"); return "login";
	 * }
	 * 
	 * userService.findByEmail(loggedInuser).ifPresent(a->{ //
	 * model.addAttribute("user_account", a); // if(a.getContactInfo() != null) { //
	 * model.addAttribute("contact_info", a.getContactInfo()); // }else { //
	 * model.addAttribute("contact_info", new ContactInfo()); // } // });
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return "profile"; }
	 * 
	 * 
	 * return "profile"; }
	 */
	@PostMapping("login")
	String login(RedirectAttributes redirect, Model model, @RequestParam String email, @RequestParam String password) {
		System.out.println("LOGGING IN");
		Optional<User> user = userService.login(email, password);
		System.out.println("check 1");
		/*
		 * List<User> users = userRespository.findAll();
		 */		if (user.isPresent()) {
			 System.out.println("USER FOUND");
			model.addAttribute("loggedInuser", user.get());
			
			model.addAttribute("role", user.get().getRole());

		} else {
			System.out.println("ERROR");
			model.addAttribute("error", "Invalid Credentials");
			return "login";
		}
		System.out.println("REDIRECTING TO PROFILE");
		return "redirect:/profile";

	}

	@GetMapping("logout")
	String logout(Model model, SessionStatus status, HttpSession session, WebRequest request) {
		status.setComplete();
		//session.invalidate();
		request.removeAttribute("loggedInuser", WebRequest.SCOPE_SESSION);
		model.addAttribute("role", "");
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("msg", "You have ben Logged out");

		return "login";

	}

	@GetMapping("register")
	String register(Model model) {
		model.addAttribute("users", new User());
		return "register";
	}

	@PostMapping("register")
	String register(@ModelAttribute User users, Model model, BindingResult result, RedirectAttributes redirect) {
		System.out.println(users.getFirstName());
		dataValidation.validate(users, result);
//		if (result.hasErrors()) {
//			System.out.println("ERROR");
//			return "register";
//		}

		users.setRole("USER");
		System.out.println("SAVING");
		userService.save(users);

		model.addAttribute("msg", "Registration Success Login");

		return "redirect:/loginpage";
	}

	@GetMapping("admin")
	String admin(Model model) {
		model.addAttribute("msg", "Admin ");
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "admin";
	}

	@GetMapping("deleteUser")
	String deleteUser(Model model, @RequestParam Long id) {

		userService.deleteById(id);
		model.addAttribute("msg", "User Deleted ");
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());

		return "admin";

	}

	@PostMapping("editrole")
	String editrole(RedirectAttributes redirect, @RequestParam("id") Long id, @RequestParam String role) {
		userService.giveRole(id, role);
		redirect.addFlashAttribute("success", "Role asigned");

		return "redirect:admin";
	}

	@PostMapping("search")
	String search(Model model, @RequestParam("keyword") String keyword) {
		List<User> users = userService.search(keyword);
		model.addAttribute("users", users);
		model.addAttribute("success", users.size() + " user(s) Found");
		model.addAttribute("user", new User());

		return "admin";
	}

	@PostMapping("lookup")
	String lookup(Model model, @RequestParam String fname, @RequestParam String lname) {
		List<User> users = userService.lookUp(fname, lname);
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		model.addAttribute("success", users.size() + " user(s) Found");
		return "admin";
	}

	@GetMapping("editUser")
	String editUser(Model model, User user) {
		model.addAttribute("msg", "Edit ");
		userService.update(user);
		return "editUser";
	}

	@PostMapping("updateUsers")
	String updateUsers(@RequestParam String email, @RequestParam String role, RedirectAttributes redirect) {

		User user = userService.findByEmail(email).get();

		if(user != null)
		{
			user.setRole(role);
			userService.save(user);
			redirect.addFlashAttribute("success", "Update success");
		}
		return "redirect:/admin";
	}

	@PostMapping("addprofileImage")
	String addImge(RedirectAttributes redirect, @RequestParam MultipartFile file, @RequestParam Long id) {

		try {
			Pattern ext = Pattern.compile("([^\\s]+(\\.(?i)(png|jpg|pdf|gif|jpeg))$)");

			if (file.getSize() > 1073741824) {
				redirect.addFlashAttribute("error", "File too large to upload " + file.getSize());
				return "redirect:profile";
			}

			Matcher mtch = ext.matcher(file.getOriginalFilename());

			if (!mtch.matches()) {
				redirect.addFlashAttribute("error", "Invalid Image type ");
				return "redirect:profile";
			}

			webUtils.addProfilePhoto(file, id, "users");
			redirect.addFlashAttribute("success", "Upload success " + file.getSize() + " kb");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:profile";

	}

	@ModelAttribute("size")
	public List<String> size() {
		List<String> size = new ArrayList<String>();
		size.add("S");
		size.add("M");
		size.add("L");
		size.add("XL");
		size.add("2X");
		size.add("3X");
		size.add("8");
		size.add("10");
		size.add("12");
		size.add("FREE SIZE");
		return size;
	}

	@ModelAttribute("colour")
	public List<String> colour() {
		List<String> col = new ArrayList<String>();
		col.add("Blue");
		col.add("Brown");
		col.add("Black");
		col.add("White");
		col.add("Green");
		col.add("Gray");
		col.add("Red");
		col.add("Yellow");
		col.add("Pink");
		col.add("Tan");
		col.add("Purple");
		col.add("Maroon");
		col.add("Gold");
		col.add("Silver");
		return col;
	}

	@ModelAttribute("states")
	public List<States> populateStates() {
		return Arrays.asList(States.values());
	}

	@ModelAttribute("product")
	Products products() {

		return new Products();

	}

}
