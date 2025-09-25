package com.training.expensemanagementsystem.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("")     //localhost:9091
	public String index() {
		return "index";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "neha";
	}
	@RequestMapping("/viewAllProducts")
	public String viewAllProducts() {
		return "viewAllProducts";
	}
	@RequestMapping("/addProduct")
	public String addProduct() {
		return "addProduct";
	}
}