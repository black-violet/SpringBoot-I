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
@RequestMapping("product")
public class ProductController {

		private ProductService productService;
		private CategoryService catService;
		
		public ProductController(ProductService productService,CategoryService catService) {
			this.productService = productService;
			this.catService = catService;
		}

		@RequestMapping(value="new", method = RequestMethod.GET)
		public String index(@ModelAttribute("product") Product product) {
			return "/newproduct.jsp";
		}
		
		@RequestMapping(value="{id}", method = RequestMethod.GET)
		public String show(@PathVariable("id") Long id, Model model) {
			Product product = productService.findProduct(id);
			List<Category> categories = catService.allCat();			
			
			model.addAttribute("product", product);
			model.addAttribute("categories", categories);

			return "/showProduct.jsp";
		}
		
		@RequestMapping(value="new", method = RequestMethod.POST)
		public String add(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if (result.hasErrors()) {
				return "/product/new.jsp";
			} else { 
				productService.createProduct(product);
				return "redirect:/product/" + product.getId(); 
			}
		}
		
		@RequestMapping(value="{id}", method = {RequestMethod.POST, RequestMethod.PUT})
		public String update(@PathVariable("id") Long prodId, @RequestParam("id") Long catId) {
			Product product = productService.findProduct(prodId);
			Category category = catService.findCat(catId);
			
			product.getCategories().add(category);
			productService.createProduct(product);
			
			return "redirect:/product/" + product.getId(); 		
		}
}
