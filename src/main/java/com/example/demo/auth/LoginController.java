package com.example.demo.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.TestDTO;

@Controller
public class LoginController {

/**
* 로그인 화면
* @return
*/
@GetMapping("/login")
public String login(HttpServletRequest request, Model model) {

    //사용자 정보가 있을 경우 바로 메인 페이지로 이동
    TestDTO session = (TestDTO)request.getSession().getAttribute(TestDTO.KEY);
    if(session != null) {
        return "redirect:/index/";
    }

    model.addAttribute("loginForm", new TestDTO());

    return "/login/login";
}
}
