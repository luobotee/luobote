package com.java.securityauthserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginSuccess {

    @RequestMapping("loginSuccess")
    public String loginSuccess() {
        return "登陆成功";
    }
}
