package com.example.demo.auth;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, RedirectAttributes rttr) throws Exception {
		String id = request.getParameter("id");
		if(id != null){
			String userId = SessionConfig.getSessionidCheck("login_id", id);
			System.out.println(id + " : " +userId);
			session.setMaxInactiveInterval(60 * 60);
			session.setAttribute("login_id", id);
			return "redirect:/home.do";
		}
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/main.do")
	public String index(HttpSession session) throws Exception {
		return "login";
	}
	
	@RequestMapping(value = "/home.do")
	public String home(HttpSession session) throws Exception {
		return "home";
	}
	
	@RequestMapping("/test")
	public ModelAndView test() throws Exception{
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "goddaehee");

		List<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");

		mav.addObject("list", testList);
		return mav;
	}
	@RequestMapping(value ="/")
	public String test1() throws Exception{
		return "home";
	}
	
	@RequestMapping(value ="/test2")
	public String test2() throws Exception{
		return "home";
	}
	@GetMapping("auth/join")
	public String joinForm() {
		return "user/join";
	}
	
	@GetMapping("auth/login")
	public String loginForm() {
		return "user/login";
	}
	@GetMapping("auth/index")
	public String loginForm2() {
		return "index";
	}


	
}