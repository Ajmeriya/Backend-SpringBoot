package com.example.thymeleafde.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //new a controller method to show the initial HTML page

    @RequestMapping("/showFrom")
    public String showFrom()
    {
        return "helloworld-from";
    }

    //need a controller method to process the from

    @RequestMapping("/processFrom")
    public String processFrom()
    {
        System.out.println("Processing from data");
        return "helloworld";
    }

}
