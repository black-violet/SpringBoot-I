package com.maria.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maria.lenguajes.models.Language;
import com.maria.lenguajes.repositories.LangRepository;



@Service 
public class LangService {
	private final LangRepository languageRepo;
	
	public LangService(LangRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return languageRepo.save(lang);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			Language updateLang = optionalLang.get();
			
			updateLang.setName(name);
			updateLang.setCreator(creator);
			updateLang.setVersion(version);
			
			return languageRepo.save(updateLang);
		} else {
			return null;
		}
	}
	
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if (optionalLang.isPresent()) {
			languageRepo.deleteById(id);
		}
	}
	
}