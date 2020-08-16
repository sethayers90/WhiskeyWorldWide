//package com.whiskeyworldwide.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.whiskeyworldwide.model.Products;
//import com.whiskeyworldwide.model.User;
//import com.whiskeyworldwide.repos.ProductsRepository;
//import com.whiskeyworldwide.repos.QuizRepository;
//import com.whiskeyworldwide.repos.UserRepository;
//
//@Controller
//@RequestMapping("/profile")
//public class ProfileController {
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	QuizRepository quizRepository;
//	@Autowired
//	ProductsRepository productsRepository;	
//	Products product = new Products();
//	@RequestMapping("/recommendations")
//	public String recommendations(Model model ,@RequestParam long id) {
//		int bbqness = 0;
//		int fruityness = 0;
//		int spicyness = 0;
//		int sweetness = 0;
//		
//		User user = userRepository.findById(id).get();
//		//get the information from the user
//		int bbq = user.getQuiz().getBbq();
//		int fruity = user.getQuiz().getFruity();
//		int spicy = user.getQuiz().getSpicy();
//		int sweet = user.getQuiz().getSweet();
//		
//		switch(bbq) {
//		case 5: bbqness = bbqness+2;
//		break;
//		case 4: bbqness = bbqness++;
//		break;
//		case 2: bbqness = bbqness --;
//		break;
//		case 1: bbqness = bbqness - 2;
//		}
//		switch(fruity) {
//		case 5: fruityness = fruityness + 2;
//		break;
//		case 4: fruityness = fruityness ++;
//		break;
//		case 2: fruityness = fruityness --;
//		break;
//		case 1: fruityness = fruityness -2;
//		}
//		switch(spicy){
//		case 5: spicyness = spicyness + 2;
//		break;
//		case 4: spicyness ++;
//		break;
//		case 2: spicyness --;
//		break;
//		case 1: spicyness = spicyness - 2;
//		}
//		switch(sweet) {
//		case 5: sweetness = sweetness + 2;
//		break;
//		case 4: sweetness ++;
//		break;
//		case 2: sweetness --;
//		break;
//		case 1: sweetness = sweetness - 2;
//		}
//		// I wanna assign the different whiskey bases on thier "ness" rating. 
//	if(bbqness==2) {
//		product.setUrl("static/img/bbq+2.jpg");
//	}
//	if(fruityness == 2) {
//		product.setUrl("static/img/fruityness+2.jpg");
//	}
//	if(spicyness == 2) {
//		product.setUrl("static/img/spicyness+2.jpg");
//	}
//	if(sweetness == 2) {
//		product.setUrl("static/img/spicyness+2.jpg");
//	}
//	if(bbqness==1) {
//		product.setUrl("static/img/bbq+1.jpg");
//	}
//	if(fruityness == 1) {
//		product.setUrl("static/img/fruityness+1.jpg");
//	}
//	if(spicyness == 1) {
//		product.setUrl("static/img/spicyness+1.jpg");
//	}
//	if(sweetness == 1) {
//		product.setUrl("static/img/spicyness+1.jpg");
//	}
//	if(bbqness >= 0 &&  fruityness >= 0 && spicyness >= 0 && sweetness >= 0) {
//		product.setUrl("static/img/basic1");
//	}
//	ArrayList<Products>whiskeys = (ArrayList<Products>) productsRepository.findAll();
//	ArrayList<Products>whiskeys1 = new ArrayList<Products>();
//		for(Products i : whiskeys) {
//			//I forgot what Alex said to put here
//			if(user.getQuiz().getBbq()>3) {
//				if(i.getBbqness()>0) {
//					whiskeys1.add(i);
//				}
//			}
//			if(user.getQuiz().getFruity()>3) {
//				if(i.getFruityness()>0) {
//					whiskeys1.add(i);
//				}
//			}
//			if(user.getQuiz().getSweet()>3) {
//				if(i.getSweetness()>0) {
//					whiskeys1.add(i);
//				}
//			}
//			if(user.getQuiz().getSpicy()>3) {
//				if(i.getSpicyness()>0) {
//					whiskeys1.add(i);
//				}
//			}
//			
//			
//		}
//		model.addAttribute("message", whiskeys1);
//		System.out.println(whiskeys1.size());
//		model.addAttribute("allWhiskeys", whiskeys.get(0));
//		
//		return "recommendations";
//	}
//}
