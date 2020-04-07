package com.practice.rest.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /*
    1. 화면에 helloworld가 출력됩니다.
    */
    @GetMapping(value = "/hello/string")
    @ResponseBody
    public String helloworldString() {
        return "hello";
    }
    /*
    2. 화면에 {message:"helloworld"} 라고 출력됩니다.
    */
    @GetMapping(value = "/hello/json")
    @ResponseBody
    public Hello helloworldJson() {
        Hello hello = new Hello();
        hello.message = "hello";
        return hello;
    }
    /*
    3. 화면에 helloworld.ftl의 내용이 출력됩니다.
    */
    @GetMapping(value = "/hello/page")
    public String hello() {
        return "hello";
    }

    @Setter
    @Getter
    public static class Hello {
        private String message;
    }
}