package com.pta.project_tracking_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pta.project_tracking_app.entity.UserLogin;
import com.pta.project_tracking_app.entity.UserRegister;
import com.pta.project_tracking_app.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService service;
	
	@ModelAttribute("user")
	public UserLogin getUserLogin() {
		return new UserLogin();
	}
	
	@ModelAttribute("newUser")
	public UserRegister getUserRegister() {
		return new UserRegister();
	}

	@RequestMapping(value="/")
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/register")
	public String getRegister() {
		return "register";
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public String processRegister(@Valid @ModelAttribute("newUser") UserRegister newUser, BindingResult br) {
		if (br.hasErrors()) {
			return "register";
		}
		service.registerUser(newUser);

		return "redirect:/";
	}
}
