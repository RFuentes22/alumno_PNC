package com.uca.capas.alumno.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class MainController {

	@RequestMapping("/ingresar")
	public String index() {
		return "ingresar";
	}


	
	@RequestMapping("/resultado")
	public ModelAndView parameters(@RequestParam String names, @RequestParam String lastnames, @RequestParam String dateborn, @RequestParam String place, @RequestParam String school, @RequestParam String phone, @RequestParam String cellular) throws ParseException {
		ModelAndView mav = new ModelAndView();
		List<String> listF = new ArrayList<>(); //list failed

		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date minDate = sdformat.parse("2003-01-01");
		
		if(names.isEmpty() && lastnames.isEmpty() && dateborn.equals("") && place.isEmpty() && school.isEmpty() && phone.isEmpty()&& cellular.isEmpty()) {
			listF.add("Ningun campo se ha llenado");
			mav.addObject("listF", listF);
			mav.setViewName("/fail");
			return mav;
			
		}
		
		
		if(dateborn.equals("")) {
			listF.add("El campo Fecha de Nacimiento no tiene ninguna fecha");
			mav.addObject("listF", listF);
			mav.setViewName("/fail");
			return mav;
		}
		Date d1 = sdformat.parse(dateborn);

		
		if(names.length() < 1 || names.length() > 25) {
			listF.add("El campo Nombres no puede ser mayor a 25 caracteres o menor a 1 caracter");
		}
		if(lastnames.length() < 1 || lastnames.length() > 25) {
			listF.add("El campo Apellidos no puede ser mayor a 25 caracteres o menor a 1 caracter");
		}
		if(d1.before(minDate)) {
			listF.add("El campo Fecha de Nacimiento no puede ser antes del 01-01-2003");
		}
		if(place.length() < 1 || place.length() > 25) {
			listF.add("El campo Lugar de Nacimiento no puede ser mayor a 25 caracteres o menor a 1 caracter");
		}
		if(school.length() < 1 || school.length() > 100) {
			listF.add("El campo Instituto o colegio de procedencia no puede ser mayor a 100 caracteres");
		}
		if(phone.length() != 8) {
			listF.add("El campo Telefono fijo tienen que ser 8 digitos");
		}
		if(cellular.length() != 8) {
			listF.add("El campo Telefono movil tienen que ser 8 digitos");
		}

		
		if(listF.size() != 0) { // Si en algo fallo
			mav.addObject("listF", listF);
			mav.setViewName("/fail");
			return mav;
		}
		mav.setViewName("/resultado");
		
		
		return mav;
	}
	
	
}
