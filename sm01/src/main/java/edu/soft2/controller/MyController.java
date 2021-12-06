package edu.soft2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/hello.do")
    public String hello(){

        return "pages";
    }                            
}
