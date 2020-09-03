package com.maria.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CountController {


	@RequestMapping(value = "/home")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/home/contador", method = RequestMethod.GET)
	public String cuenta( HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count== null) {
			session.setAttribute("count", 0);
		}else {
			count +=1;
			session.setAttribute("count", count);
		}
		return "contador.jsp";
	}
}