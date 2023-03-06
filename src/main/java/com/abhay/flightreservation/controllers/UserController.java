package com.abhay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhay.flightreservation.entities.User;
import com.abhay.flightreservation.repos.UserRepository;
import com.abhay.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityService securityService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute(value = "user") User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid user name of password. please try again.");

		}

		return "login/login";
	}

}
