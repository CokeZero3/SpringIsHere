package com.care.membership;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.HandlerMapping;


@SessionAttributes("sessionInfo")
@RequestMapping("membership")
@Controller
public class ControllerImpl {
	private static final Logger logger = LoggerFactory.getLogger(ControllerImpl.class);
	
	@Autowired
	private IService iServ;
	
	@ModelAttribute("sessionInfo")
	public Map<String, Object> getSessionInfo(){
		return new HashMap<String, Object>();
	}
	
	@RequestMapping("reqAuthNum")
	public String reqAuthNum(Member member, Model model, 
			@ModelAttribute("sessionInfo") Map<String, Object> sInfo) {
		iServ.reqAuthNum(sInfo);
		/* model.addAttribute("sessionAuthNum", iServ.reqAuthNum()); */
		model.addAttribute("msg", "인증번호를 이메일로 전송하였습니다.");
		model.addAttribute("member", member);
		
		return "forward:/membership";
	}
	@RequestMapping("authNumConfirm")
	public String authNumConfirm(Member member, Model model, 
			@ModelAttribute("sessionInfo") Map<String, Object> sInfo,  
			@RequestParam("authNum") String reqAuthNum 
			/*SessionStatus session*/) {
		/* String sAuthNum = (String)model.getAttribute("sessionAuthNum"); */
		model.addAttribute("msg", iServ.authNumConfirm(sInfo, reqAuthNum/* , session */));
		model.addAttribute("member", member);
		
		return "forward:/membership";
	}
	@RequestMapping("searchPostCode")
	public String searchPostCode() {
		return "MemberForm/searchPostCodeForm";
	}
	
	@RequestMapping("searchZipcode")
	public String searchZipcode(@RequestParam("addr") String addr, Model model) {
		model.addAttribute("zipcodeLst", iServ.searchZipcode(addr));
		return "MemberForm/searchPostCodeForm";
	}
	@RequestMapping("memberProc")
	public String memberProc(Member member, 
			@ModelAttribute("sessionInfo") Map<String, Object> sInfo, 
			Model model) {
		if(iServ.memberProc(member, sInfo))
			return "forward:/login";
		
		model.addAttribute("msg", "회원가입에 실패하였습니다.");
		return "forward:/membership";
	}
	@RequestMapping({"searchID", "searchPW"})
	public String searchIDPW(Model model, HttpServletRequest req) {
		String path = (String)req.getAttribute(
				HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		logger.warn(path);
		model.addAttribute("path", path);
		return "forward:/findInfo";
	}
	@RequestMapping("findInfoProc")
	public String findInfoProc(@RequestParam("email") String email, 
			@RequestParam(value = "id", required = false) String id, 
			Model model
			) {
		model.addAttribute("msg", iServ.FindInfoProc(email, id));
		return "forward:/login";
	}
	@RequestMapping("isExistID")
	public String isExistID(Member member, Model model, 
			@ModelAttribute("sessionInfo") Map<String, Object> sInfo) {
		model.addAttribute("msg", iServ.isExistId(member,sInfo));
		model.addAttribute("member", member);
		
		return "forward:/membership";
	}
	@RequestMapping("loginProc")
	public String loginProc(Login login, Model model) {
		if(iServ.loginProc(login))
			return "redirect:/home";
		model.addAttribute("msg", "회원 정보가 잘못되었습니다.");
		
		return "forward:/login";
	}
}







