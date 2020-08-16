package com.whiskeyworldwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.whiskeyworldwide.model.Products;
import com.whiskeyworldwide.repos.ProductsRepository;
import com.whiskeyworldwide.repos.UserRepository;

@Controller
public class ProductController {
	@Autowired
	ProductsRepository productRepository;
	@Autowired
	UserRepository userRepository;
	//I want to make this like an admin page where whiskeys can be added and deleted.
	@PostMapping("addinventory")
	String addInventory(@ModelAttribute Products products, Model model) {
		//I don't think I can put the form here, but, I think if I make a get mapping on the actual page that will
		//work
		
		return "admin";
	}
	@GetMapping("deleteinventory")
	String deleteInventory(@ModelAttribute Products products, Model model) {
		//Same as above use a I think getmapping on the jsp page
		
		
		return "admin";
	}
		
}
