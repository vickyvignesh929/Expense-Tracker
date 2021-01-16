package com.tracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tracker.entity.UserData;
import com.tracker.service.DataBaseServiceImpl;

@Controller
public class AuthenticationController {
	
	DataBaseServiceImpl databaseserviceimpl=new DataBaseServiceImpl();
	@RequestMapping("/")
	public String Page() {
		return "bottomdata";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/signup")
	public String SignUpPage() {
		return "signup";
	}

	@RequestMapping("/adduser")
	public String adduser(@ModelAttribute("userdata") UserData user, BindingResult result) {
		if (databaseserviceimpl.addUser(user))
			return "login";
		else {

			result.rejectValue("username", "", "username already taken. Try another");
			return "signup";

		}

	}

	@RequestMapping("/dashboard")
	public String checklogin(@ModelAttribute("userdata") UserData user, BindingResult result, HttpSession session) {
		

		if (databaseserviceimpl.checkUser(user)) {
			session.setAttribute("user", user.getUsername());

			return "dashboard";
		} else
			result.rejectValue("username", "", "Invalid credentials");
		return "login";

	}

}