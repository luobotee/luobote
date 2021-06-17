package com.java.frontendsystem.controller;


import com.java.frontendsystem.feign.SecondTestFeign;
import com.java.secondtest.entity.Sectest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/Second")
public class SecondTestController {

    @Resource
    private SecondTestFeign secondTestFeign;

    @GetMapping("/test")
    public String SecondTest() {
        return "SecondTest/test";
    }

    @GetMapping("/list")
    public String SecondList() {
        return "SecondTest/list";
    }

    @GetMapping("/create")
    public String CreateDate() {
        return "SecondTest/add";
    }

    @GetMapping("/update")
    public String UpdateDate(Integer id, ModelMap modelMap) {
        Sectest sectest = secondTestFeign.UpdateDao1(id);
        modelMap.addAttribute("sectest", sectest);
        return "SecondTest/edit";
    }

}
