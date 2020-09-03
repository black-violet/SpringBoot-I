package com.maria.codigo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/code")
	public String flashMessages(RedirectAttributes redirectAttributes,@RequestParam(value="code") String code) {
		if(code.equals("pera")) {
        return "secret.jsp";
		}else {
	          redirectAttributes.addFlashAttribute("error", "Entrena Más Duro");
	        return "redirect:/";
		}
	}
	
	
}