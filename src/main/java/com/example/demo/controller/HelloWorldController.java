package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    /*@GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping(value="/request1")
    public String getRequestParam1(
    		@RequestParam String name,
    		@RequestParam String email,
    		@RequestParam String organization) {
    	return name + " "+ email+ " "+ organization;
    	
    }
    
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
    	StringBuilder sb = new StringBuilder();
    	
    	param.entrySet().forEach(map->{
    		sb.append(map.getKey()+":"+map.getValue() + "\n");
    	});
    	
    	return sb.toString();
    }*/
}