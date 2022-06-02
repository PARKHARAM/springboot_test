package com.example.demo.auth;

import javax.servlet.http.HttpSession; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class RedisSampleController {        
	@GetMapping("/getSessionId")    
	public String getSessionId(HttpSession session) 
	{        return session.getId();    
	
	}
	
}
