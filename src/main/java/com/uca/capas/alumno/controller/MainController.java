package com.uca.capas.alumno.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class MainController {

	@RequestMapping("/ingresar")
	public String index() {
		return "ingresar";
	}



	
	
}
