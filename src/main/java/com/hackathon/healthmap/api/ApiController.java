package com.hackathon.healthmap.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @ResponseBody
    @RequestMapping(value="/log", method= RequestMethod.GET)
    public String getLog(HttpServletRequest request){
        return "Hello";
    }
}
