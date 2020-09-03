package com.maria.lenguajes.controllers;

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

import com.maria.lenguajes.models.Language;
import com.maria.lenguajes.services.LangService;


@Controller 
public class LangController {
	private final LangService langService;
	
	public LangController(LangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping(value="languages", method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		
		return "/lang/index.jsp";
	}
	
	@RequestMapping(value="languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> languages = langService.allLanguages();
			model.addAttribute("languages", languages);
			
			return "/languages/index.jsp";
		} else {
			langService.createLanguage(language);
			
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLanguage(id);
		
		model.addAttribute("language", language);
		
		return "/lang/show.jsp";
	}
	
	@RequestMapping(value="languages/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLanguage(id);
		
		model.addAttribute("language", language);	
		
		return "/lang/edit.jsp";
	}
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.PUT)
	public String update(
			@Valid
			@ModelAttribute("language") Language language,
			BindingResult result,
			@PathVariable("id") Long id,
			@RequestParam(value="name") String name, 
			@RequestParam(value="creator") String creator, 
			@RequestParam(value="version") String version
			) {
		if (result.hasErrors()) {
			return "lang/edit.jsp";
		} else {
			langService.updateLanguage(id, name, creator, version);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destory(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
}