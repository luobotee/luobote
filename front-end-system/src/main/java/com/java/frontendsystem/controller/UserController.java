package com.java.frontendsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author luozhong
 * @since 2021-06-13
 */
@Controller
@RequestMapping("/Home")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "Login/login";
    }

    @GetMapping("/index")
    public String index() {
        return "HomePage/index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "HomePage/welcome";
    }

}
