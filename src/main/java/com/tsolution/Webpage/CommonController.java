package com.care.WebPage;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	private Map<String, String> pageMap;
	
	public CommonController() {
		pageMap = new HashMap<String, String>();
		pageMap.put("home", "home");
		pageMap.put("login", "MemberForm/loginForm");
		pageMap.put("membership", "MemberForm/memberForm");
		pageMap.put("findInfo", "MemberForm/findInfoForm");
		pageMap.put("board", "BoardForm/boardForm");
	}
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "redirect:/home";
	}
	@RequestMapping(value = "/{formPath}")
	public String home(Model model, @PathVariable String formPath) {
		model.addAttribute("formPath", "form/"+formPath );
		
		return "index";
	}
	@RequestMapping(value = "/form/{formPath}")
	public String formHome(@PathVariable String formPath) {
		return pageMap.get(formPath);
	}
}









