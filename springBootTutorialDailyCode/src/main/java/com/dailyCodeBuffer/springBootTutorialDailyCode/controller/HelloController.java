
package com.dailyCodeBuffer.springBootTutorialDailyCode.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class HelloController {
    @GetMapping("/getHello")
    public String helloWorld()
    {
        return  "hellowroldqqq";
    }
}

