package com.whiskeyworldwide.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.whiskeyworldwide.model.Products;
import com.whiskeyworldwide.model.User;
import com.whiskeyworldwide.repos.ProductsRepository;
import com.whiskeyworldwide.repos.UserRepository;
import com.whiskeyworldwide.utils.WebUtils;

@Controller
@SessionAttributes({"loggedInuser","role"})
public class AppController {
	
	@Autowired
	WebUtils webUtils;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	
	String about="The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale and theme resolution as well as support for uploading files. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the @Controller mechanism also allows you to create RESTful Web sites and applications, through the @PathVariable annotation and other features.";
	
	@GetMapping("index")
	String homepage(Model model) {
		/*
		 * List<User> myList = userRepository.findAll(); model.addAttribute("users",
		 * myList); model.addAttribute("index", "active");
		 */	
	return "index";		
	}
	@GetMapping("welcome")
	String welcome(Model model) {
		return "welcome";
	}
	@GetMapping("about")
	String aboutUs(Model model) {
		model.addAttribute("message", "About us page");
		model.addAttribute("about", "active");
	return "about";
	}
	@GetMapping("quiz")
	String quiz(Model model) {
		model.addAttribute("msg", "Thank you!");
		return "quiz";
	}
	@GetMapping("contact")
	String contactus(Model model) {
		
	return "contact";
	}
	@GetMapping("nope")
	String nope(Model model) {
		
		return "nope";
	}
	@GetMapping("loginpage")
	String loginpage(Model model) {
		return "loginpage";
	}
	@GetMapping("registerpage")
	String registerpage(Model model) {
		model.addAttribute("users", new User());
		return "registerpage";
	}
	/*
	 *
	 */
	@GetMapping("page")
	String getpage(Model model, @RequestParam String link, @RequestParam String name) {
	model.addAttribute("message", "Link is "+ link+" and Name = "+name);	
	
	return "contact";
	}
	
	@GetMapping("profile")
	String profile(Model model) {
		User user = (User)model.getAttribute("loggedInuser");
		System.out.println("NAME=" + user.getFirstName());
		ArrayList<Products>whiskeys = (ArrayList<Products>) productsRepository.findAll();
		ArrayList<Products>whiskeys1 = new ArrayList<Products>();
		if(user.getQuiz() != null) {
			for(Products i : whiskeys) {
				//I forgot what Alex said to put here
				if(user.getQuiz().getBbq()>3) {
					if(i.getBbqness()>0) {
						whiskeys1.add(i);
					}
				}
				if(user.getQuiz().getFruity()>3) {
					if(i.getFruityness()>0) {
						whiskeys1.add(i);
					}
				}
				if(user.getQuiz().getSweet()>3) {
					if(i.getSweetness()>0) {
						whiskeys1.add(i);
					}
				}
				if(user.getQuiz().getSpicy()>3) {
					if(i.getSpicyness()>0) {
						whiskeys1.add(i);
					}
				}
				
				
			}
		}
			//model.addAttribute("message", whiskeys1);
			//System.out.println(whiskeys1.size());
			model.addAttribute("allWhiskeys", whiskeys);
		
		
		return "profile";
	}
	
	@GetMapping("addWhiskey")
	String addWhiskey(Model model) {
		model.addAttribute("products", new Products());
		
		return "addWhiskey";
	}
	
	@PostMapping("addWhiskey")
	String addWhiskey(@ModelAttribute Products product , Model model) {
		System.out.println("SAVING WHISKEY");
        productsRepository.save(product);
        model.addAttribute("productList", productsRepository.findAll());
		return "admin";
	}
	
	
	
	
	@PostMapping("sendemail")
	String sendemail(@RequestParam String lastname, 
			@RequestParam String email,
			@RequestParam String subject,
			@RequestParam String message,
			Model model){
		
		try {
			webUtils.sendMail(email, message+" From "+lastname, subject);
			model.addAttribute("msg", "Message sent thanks");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error", "Error sendind Message sorry"+e);
		}
		
	return "contact";		
	}
	
	@GetMapping("login")
	String logipage(Model model) {
		model.addAttribute("login", "active");
	return "login";
	}
	/*
	@GetMapping("pathvar-{link}-{name}")
	String getpaths(Model model, @PathVariable String link, @PathVariable String name) {
	model.addAttribute("message", "Link is "+ link+" and Name = "+name);	
	
	return "contact";
	}*/
	
	@GetMapping("spring")
	@ResponseBody
	String aboutspring() {
		
	return "spring about "+about;
		
		
	}

}
