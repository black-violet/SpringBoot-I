package com.maria.commerce.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maria.commerce.models.Category;
import com.maria.commerce.models.Product;
import com.maria.commerce.services.CategoryService;
import com.maria.commerce.services.ProductService;

@Controller 
@RequestMapping("categories")
public class CategoryController {
	private CategoryService catService;
	private ProductService productService;
	
	public CategoryController(CategoryService catService,ProductService productService) {
		this.catService = catService;
		this.productService = productService;
	}

	@RequestMapping(value="new", method = RequestMethod.GET)
	public String index(@ModelAttribute("category") Category category) {
		return "newcat.jsp";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Category category = catService.findCat(id);
		List<Product> products = productService.allProduct();
		
		model.addAttribute("category", category);
		model.addAttribute("products", products);

		return "showCat.jsp";
	}
	
	@RequestMapping(value="new", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newcat.jsp";
		} else { 
			catService.createCat(category);
			return "redirect:/categories/" + category.getId(); 
		}
	}
	@RequestMapping(value="{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(@PathVariable("id") Long catId, @RequestParam("id") Long prodId) {
		Category category = catService.findCat(catId);
		Product product = productService.findProduct(prodId);
		
		category.getProducts().add(product);
		catService.createCat(category);
		
		return "redirect:/categories/" + category.getId(); 		
	}
	
}
