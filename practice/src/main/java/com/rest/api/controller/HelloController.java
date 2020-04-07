package com.rest.api.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping(value = "/hello/string")
    @ResponseBody
    public String helloString(){
        return "hello";
    }

    @GetMapping(value = "/hello/json")
    @ResponseBody
    public Hello helloJson(){
        Hello hello = new Hello();
        hello.message = "hello";
        return hello;
    }

    @GetMapping(value = "/hello/page")
    public String helloPage(){
        return "hello";
    }

    @Setter
    @Getter
    public static class Hello{
        private String message;
    }
}
