package com.maria.lenguajes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maria.lenguajes.models.Language;
import com.maria.lenguajes.services.LangService;


@RestController
public class LangApi {

	private final LangService langService;

	public LangApi(LangService langService) {
		this.langService = langService;
	}
	
    @RequestMapping("/api/language")
    public List<Language> index() {
        return langService.allLanguages();
    }
    @RequestMapping(value="/api/language", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="cv") String cv) {
    	Language lang = new Language(name, creator, cv);
        return langService.createLanguage(lang);
    }
    
    @RequestMapping("/api/language/{id}")
    public Language show(@PathVariable("id") Long id) {
    	Language lang = langService.findLanguage(id);
        return lang;
    }
    
    @RequestMapping(value="/api/language/{id}/edit", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name,@RequestParam(value="creator") String creator, @RequestParam(value="cv") String currentVersion) {
    	Language l = langService.updateLanguage(id, name, creator, currentVersion);
        return l;
    }
    
    @RequestMapping(value="/api/language/{id}/delete", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        langService.deleteLanguage(id);
    }
}
