package com.whiskeyworldwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.whiskeyworldwide.model.Quiz;
import com.whiskeyworldwide.model.User;
import com.whiskeyworldwide.repos.QuizRepository;
import com.whiskeyworldwide.repos.UserRepository;

@Controller
@SessionAttributes({ "loggedInuser", "role" })
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	QuizRepository quizRepository;

	@GetMapping("processForm")
	public String processForm(Model model, @RequestParam String sweet,@RequestParam String spicy,@RequestParam String fruit, @RequestParam String bbq, @RequestParam long id) {
		System.out.println(id);
		User user = userRepository.findById(id).get();
		System.out.println("Name=" + user.getFirstName());
		System.out.println(spicy);
		System.out.println(sweet);
		System.out.println(fruit);
		System.out.println(bbq);
		
		Quiz quiz = new Quiz();
		quiz.setFruity(Integer.parseInt(fruit));
		quiz.setBbq(Integer.parseInt(bbq));
		quiz.setSpicy(Integer.parseInt(spicy));
		quiz.setSweet(Integer.parseInt(sweet));
		//System.out.println("ID=" + user.getId());
		quiz.setUser(user);
		//System.out.println("QUIZUSERID= " + quiz.getUser().getId());
	
		user.setQuiz(quiz);
		quizRepository.save(quiz);
		
		
//		user.getQuiz().setFruity(Integer.parseInt(fruit));
//		
//		
//		user.getQuiz().setBbq(Integer.parseInt(bbq));
//		
//		user.getQuiz().setSpicy(Integer.parseInt(spicy));
//		
//		user.getQuiz().setSweet(Integer.parseInt(sweet));
		

		return "profile";
	}
	@GetMapping("Welcome")
	public String welcome(Model model) {
		User user1 = new User();
		String welcome = ", " + user1.getFirstName();
		model.addAttribute("message", welcome);
		return "welcome";
	}
}
