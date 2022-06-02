package com.example.demo.auth;

import com.example.demo.auth.MyUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.auth.ExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExController {
    private final ExService service;


    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/index.html")
    public String index2() {
        return "index";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/product")
    public String product() {
        return "product";
    }
    @GetMapping("/singlepost")
    public String singlepost() {
        return "singlepost";
    }

    @GetMapping("/duplicatedlogin")
    public String duplicatedlogin() {
        return "duplicatedlogin";
    }
    @GetMapping("/homepage")
    public String home() {
        return "homepage";
    }
    
    @GetMapping("/test.html")
    public String test() {
        return "test";
    }

    
    
    @PostMapping("/signUp")
    public String signUp(User user) {
        user.setRole("USER");
        service.joinUser(user);
        log.info(user.getEmail());
        return "redirect:/login";
    }
/*
    @GetMapping("/")
    public String userAccess(Model model, Authentication authentication) {
        
        if(!(authentication == null)) {
        	 MyUserDetail userDetail = (MyUserDetail)authentication.getPrincipal();
        	 log.info(userDetail.getUsername());
             model.addAttribute("info", userDetail.getUsername());
         	return "homepage";
        }
        else {
        	return "index";
        }
        
    }
    
*/

}