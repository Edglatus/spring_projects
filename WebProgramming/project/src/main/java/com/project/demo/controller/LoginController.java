package com.project.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("/login")
public class LoginController {
	@GetMapping @PostMapping
	public ModelAndView login()	{
		return (new ModelAndView("login"));
	}	
}
