package com.maria.contador;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    @RequestMapping("/")
    public Integer index(HttpSession session){
    	
    	Integer count = (Integer) session.getAttribute("count");
		if(count== null) {
			session.setAttribute("count", 0);
		}else {
			count +=1;
			session.setAttribute("count", count);
		}
		return count;
    }
}
