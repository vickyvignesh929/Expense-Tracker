package com.tracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.entity.MonthlyLimitTable;
import com.tracker.service.DataBaseServiceImpl;

@Controller
public class navigationController {

	DataBaseServiceImpl databaseserviceimpl = new DataBaseServiceImpl();

	@RequestMapping("/addacategory")
	public String Category() {
		return "category";
	}

	@RequestMapping("/home")
	public String goHome() {
		return "dashboard";
	}

	@RequestMapping("/addcategory")
	public String addCategory(@RequestParam("function") String function, @RequestParam("category") String category) {
		databaseserviceimpl.addCategory(function, category);
		return "dashboard";
	}

	@RequestMapping("/limitpage")
	public String goLimitPage() {
		return "limitpage";
	}

	@RequestMapping("/addlimit")
	public String addLimitPage(@ModelAttribute("limit") MonthlyLimitTable limit, HttpSession session) {
		limit.setUsername((String) session.getAttribute("user"));
		databaseserviceimpl.addLimit(limit);
		return "redirect:limitpage";
	}

	@RequestMapping("/deletelimit")
	public String deleteLimitPage(@RequestParam("category") String category, HttpSession session) {
		databaseserviceimpl.deleteLimit(category, (String) session.getAttribute("user"));
		return "redirect:limitpage";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping("/customsearch")
	public String CustomSearchPage() {
		return "customsearchpage";
	}

	@RequestMapping("/searchdate")
	public String CustomSearchdata(@RequestParam("fromdate") String from, @RequestParam("todate") String to,
			HttpSession session, ModelMap model) {
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		return "customdatapage";
	}

	@RequestMapping("/customyearsearch")
	public String CustomSearchyearPage() {
		return "yearcustompage";
	}
}
