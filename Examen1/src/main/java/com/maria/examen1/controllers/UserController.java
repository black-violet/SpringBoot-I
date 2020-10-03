package com.maria.examen1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maria.examen1.models.User;
import com.maria.examen1.services.UserService;
import com.maria.examen1.validation.UserValidator;

@Controller
public class UserController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
 
	 @RequestMapping(value={"/"})
	 public String FormPage(@ModelAttribute("user") User user) {
	     return "index.jsp";
	 }


 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
			 userValidator.validate(user, result);
		 if(result.hasErrors()) {
			 return "index.jsp";
		 }else {
		 User u = userService.registerUser(user);
		 session.setAttribute("userId", u.getId());
		 return "redirect:/shows";
		 }
	 }
	 

	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	//Si el usuario está autenticado, guarde su id de usuario en el objeto Session	
		boolean isAuthenticated = userService.authenticateUser(email, password); 
		if(isAuthenticated) {
			User u =userService.findByEmail(email);
		session.setAttribute("userId", u.getId());
		return "redirect:/shows";
		}else {
			model.addAttribute("error", "invalid Credentials. Please try again.");
		
	//sino agregue un mensaje de error y retorne a la página de inicio de sesión.	 
		 
		 return "index.jsp";
		}
	 }
	 
	 
	 @RequestMapping("/shows")
	 public String home(HttpSession session, Model model) {
	     //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal						
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("user",u);
		 return "homepage.jsp";
	 }
	 
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidar la sesión
		 session.invalidate();
	     // redireccionar a la página de inicio de sesión.
		 return "redirect:/";
	 }
	 
}
