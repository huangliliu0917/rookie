package com.cainiao.exclusive.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangkecheng on 2018/6/27.
 */
@Controller
public class HelloWordController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String test(String param) {
        return param;
    }

}
