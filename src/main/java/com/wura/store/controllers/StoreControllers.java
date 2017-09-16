package com.wura.store.controllers;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wura.store.models.Category;
import com.wura.store.models.Product;
import com.wura.store.services.StoreService;

@Controller
public class StoreControllers {
	private final StoreService service;
	public StoreControllers(StoreService service) {
		this.service = service;
	}
	
	@RequestMapping("/product/new")
	public String product(@ModelAttribute("newProduct") Product product) {
		return "newProduct";
	}
	@PostMapping("/product/new")
	public String newProduct(@ModelAttribute("newProduct") Product product) {
		service.addProduct(product);
		return "redirect:/product/new";
	}
	@RequestMapping("/category/new")
	public String category(@ModelAttribute("newCategory") Product product) {
		return "newCategory";
	}
	@PostMapping("/category/new")
	public String newCategory(@ModelAttribute("newCategory") Category category) {
		service.addCategory(category);
		return "redirect:/category/new";
	}
	
	@RequestMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", service.findProduct(id));
		ArrayList<Category> result = new ArrayList<Category>();
		for(Category val:service.allCategories()) {
			if(service.findProduct(id).getCategories().contains(val) == false) {
				result.add(val);
			}
		}
		model.addAttribute("unadded", result);
		return "viewProduct";
	}
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(@RequestParam("category") Long id, @PathVariable("id") Long id2) {
		service.add(service.findProduct(id2), service.findCategory(id));
		return "redirect:/products/{id}";
	}
	
	@RequestMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", service.findCategory(id));
		ArrayList<Product> result = new ArrayList<Product>();
		for(Product val:service.allProducts()) {
			if(service.findCategory(id).getProducts().contains(val) == false) {
				result.add(val);
			}
		}
		model.addAttribute("unadded", result);
		return "viewCategory";
	}
	@PostMapping("/categories/{id}")
	public String addProductToCategory(@RequestParam("product") Long id, @PathVariable("id") Long id2) {
		service.add(service.findProduct(id), service.findCategory(id2));
		return "redirect:/categories/{id}";
	}
}
