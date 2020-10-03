package com.maria.examen1.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.maria.examen1.models.User;


@Component
public class UserValidator implements Validator {

	
    @Override
    public boolean supports(Class<?> clazz) {
        return com.maria.examen1.models.User.class.equals(clazz);
    }
    
   
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
          
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
    	
}
