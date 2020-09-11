package com.tracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracker.entity.chartsData;
import com.tracker.service.DataBaseManagementSystem;

@Controller

public class chartsController {
	@RequestMapping(value = "/monthlyexpensechart", method = RequestMethod.GET)
	public String monthlyExpenseChart() {
		return "monthlyexpensecharts";
	}

	@RequestMapping(value = "monthlyexpensedata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> expenseData(HttpSession session) {
		List<chartsData> list = DataBaseManagementSystem.getChartsData((String) session.getAttribute("user"), "expense",
				"MONTH");
		System.out.println(list);
		return list;

	}

	@RequestMapping(value = "/monthlyincomechart", method = RequestMethod.GET)
	public String monthlyIncomeChart() {
		return "monthlyincomecharts";
	}

	@RequestMapping(value = "monthlyincomedata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> Incomedata(HttpSession session) {
		List<chartsData> list = DataBaseManagementSystem.getChartsData((String) session.getAttribute("user"), "income",
				"MONTH");
		System.out.println(list);
		return list;

	}

	@RequestMapping(value = "/yearlyexpensechart", method = RequestMethod.GET)
	public String yearlyExpenseChart() {
		return "yearlyexpensecharts";
	}

	@RequestMapping(value = "yearlyexpensedata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> yearlyExpenseData(HttpSession session) {
		List<chartsData> list = DataBaseManagementSystem.getChartsData((String) session.getAttribute("user"), "expense",
				"YEAR");
		System.out.println(list);
		return list;

	}

	@RequestMapping(value = "/yearlyincomechart", method = RequestMethod.GET)
	public String yearlyIncomeChart() {
		return "yearlyincomecharts";
	}

	@RequestMapping(value = "yearlyincomedata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> yearlyIncomeData(HttpSession session) {
		List<chartsData> list = DataBaseManagementSystem.getChartsData((String) session.getAttribute("user"), "income",
				"YEAR");
		System.out.println(list);
		return list;

	}

	@RequestMapping(value = "searchdata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> searchData(HttpSession session,@RequestParam("monthyear") String month) {
		List<chartsData> list = DataBaseManagementSystem.getSearchData((String) session.getAttribute("user"),month);
		System.out.println(list);
		return list;

	}
	
	@RequestMapping(value = "searchyeardata", method = RequestMethod.GET)
	@ResponseBody
	public List<chartsData> searchYearData(HttpSession session,@RequestParam("year") String year) {
		List<chartsData> list = DataBaseManagementSystem.getSearchYearData((String) session.getAttribute("user"),year);
		System.out.println(list);
		return list;

	}
}
