package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class MainController {
    @GetMapping("/hello")
    public ModelAndView Hello(ModelAndView mv){
        mv.setViewName("hello");
        mv.addObject("hello","Test1234");
        return mv;
    }
    @GetMapping("hello-mvc")
    public ModelAndView HelloMvc(@RequestParam("name") String name, ModelAndView mv){
        mv.setViewName("hello-mvc");
        mv.addObject("name",name);
        return mv;
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public HashMap<String,String> helloApi(@RequestParam("name") String name){
        HashMap<String,String> mv = new HashMap<String,String>();
        mv.put("name",name);
        return mv;
    }
}
