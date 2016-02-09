package com.ajay.printers.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/**")
public class ToModuleController {
	@RequestMapping(value = "/home/", method = RequestMethod.GET)
	public String adminHome(ModelMap model,HttpSession httpSession) {
		httpSession.setAttribute("activeclass", "home");
		System.out.println(httpSession.getAttribute("activeclass"));
		return "card";
	}

	@RequestMapping(value = "/management/", method = RequestMethod.GET)
	public String adminBase(ModelMap model,HttpSession httpSession) {
		httpSession.setAttribute("activeclass", "management");
		System.out.println(httpSession.getAttribute("activeclass"));
		return "cardtype";
	}

}
