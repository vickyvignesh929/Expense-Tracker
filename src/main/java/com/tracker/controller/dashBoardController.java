package com.tracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.service.DataBaseManagementSystem;

@Controller
public class dashBoardController {
	@RequestMapping("/addincome")
	public String addIncome(@ModelAttribute("income") IncomeTable income, HttpSession session) {
		System.out.println(session.getAttribute("name"));
		DataBaseManagementSystem.addIncome(income, (String) session.getAttribute("user"));
		return "redirect:/home";
	}

	@RequestMapping("/addexpense")
	public String addExpense(@ModelAttribute("expense") ExpenseTable expense, HttpSession session) {
		DataBaseManagementSystem.addExpense(expense, (String) session.getAttribute("user"));
		return "redirect:/home";
	}

	@RequestMapping("/deleteincome")
	public String deleteIncome(@RequestParam("id") int id,HttpSession session) {
		DataBaseManagementSystem.deleteIncome(id);
		return "redirect:/home";
	}
	@RequestMapping("/deleteexpense")
	public String deleteExpense(@RequestParam("id") int id,HttpSession session) {
		DataBaseManagementSystem.deleteExpense(id);
		return "redirect:/home";
	}
	
	
}