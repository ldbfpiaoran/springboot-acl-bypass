package com.neo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
    @RequestMapping("/open/hello")
    public String index() {
        return "open";
    }

    @RequestMapping("/inter/hello")
    public String inter() {
        return "inter";
    }

    @RequestMapping("/admin/hello")
    public String admin() {
        return "admin";
    }


    @RequestMapping("/failed")
    public String faild() {
        return "faild";
    }
    
    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        return "test";
    }
}