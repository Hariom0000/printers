package com.ajay.printers.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ajay.printers.constants.CommonConstants;
import com.ajay.printers.constants.SessionConstants;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.User;
import com.ajay.printers.service.UserService;

@Controller
@SuppressWarnings({"unchecked","unused"})
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")
	public String indexPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest httpServletRequest,
			Principal principal) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String category = (String) httpServletRequest.getSession()
				.getAttribute("category");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth
				.getAuthorities();
		String name = principal.getName();

		HttpSession session = httpServletRequest.getSession();
		session.setAttribute(CommonConstants.USER_NAME, name);
		logger.info("logined uer name ......"+name);

		User user = (User) session.getAttribute(SessionConstants.USER_INFO);
		if (user == null) {
			String userName = principal.getName();
			logger.info("Login attempt failed for user: " + userName
					+ ". Loading user info in session");
			user = userService.getUserByUserName(userName);
			Integer userId = user.getId();
			for (GrantedAuthority authority : authorities) {
				String role = authority.getAuthority();
				session.setAttribute(CommonConstants.ROLE_ADMIN, role);
				logger.info("logined uer Role ......"+role);
			}
			logger.info("login user_Id..........."+userId);
			logger.info("login user_info..........."+userId);
			session.setAttribute(CommonConstants.USER_ID, user);
			session.setAttribute(SessionConstants.USER_INFO, user);
			user.setLastLoginTime(new Date());
			userService.update(user);
		}

		String pageToForward = null;

		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equalsIgnoreCase(
					CommonConstants.ROLE_ADMIN)) {
				pageToForward = "/admin/home";
				logger.info("redirect to ......"+pageToForward);
				break;
			} else if (authority.getAuthority().equalsIgnoreCase(
					CommonConstants.ROLE_EMPLOYEE)) {
				pageToForward = "/employee/home";
				logger.info("redirect to ......"+pageToForward);
				break;
			} else if (authority.getAuthority().equalsIgnoreCase(
					CommonConstants.ROLE_STUDENT)) {
				pageToForward = "/student/home";logger.info("redirect to ......"+pageToForward);
				break;
			}

			else {
				pageToForward = "/user/homelogout";
				logger.info("redirect to ......"+pageToForward);
			}
		}

		if (pageToForward == null) {
			pageToForward = "logout";
		}

		return "redirect:" + pageToForward;

	}

	
	
	@RequestMapping(value = "/loginfailed")
	public String loginFailed() {
		return "login";
	}

}
