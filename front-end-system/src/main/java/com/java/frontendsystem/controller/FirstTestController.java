package com.java.frontendsystem.controller;

import com.java.firsttest.entity.Firtest;
import com.java.frontendsystem.feign.FirstTestFeign;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/First")
public class FirstTestController {

    @Resource
    FirstTestFeign firstTestFeign;

    @GetMapping("/test")
    public String FirstTest() {
        return "FirstTest/test";
    }

    @GetMapping("/list")
    public String FirstList() {
        return "FirstTest/list";
    }

    @GetMapping("/create")
    public String CreateDate() {
        return "FirstTest/add";
    }

    @GetMapping("/update")
    public String UpdateDate(Integer id, ModelMap modelMap) {
        Firtest firtest = firstTestFeign.UpdateDao1(id);
        modelMap.addAttribute("firtest", firtest);
        return "FirstTest/edit";
    }

}
