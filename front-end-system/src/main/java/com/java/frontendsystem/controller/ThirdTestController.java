package com.java.frontendsystem.controller;

import com.java.frontendsystem.feign.ThirdTestFeign;
import com.java.thirdtest.entity.Thirtest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Third")
public class ThirdTestController {
    @Resource
    private ThirdTestFeign thirdTestFeign;

    @GetMapping("/test")
    public String ThirdTest() {
        return "ThirdTest/test";
    }

    @GetMapping("/list")
    public String ThirdList() {
        return "ThirdTest/list";
    }

    @GetMapping("/create")
    public String CreateDate() {
        return "ThirdTest/add";
    }

    @GetMapping("/update")
    public String UpdateDate(Integer id, ModelMap modelMap) {
        Thirtest thirtest = thirdTestFeign.UpdateDao1(id);
        modelMap.addAttribute("Thirtest", thirtest);
        return "ThirdTest/edit";
    }
}
