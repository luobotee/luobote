package com.java.frontendsystem.controller;

import com.java.firsttest.entity.Temporary;
import com.java.frontendsystem.feign.FirstTestFeign;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Temporary")
public class TemporaryController {
    @Resource
    FirstTestFeign firstTestFeign;

    @GetMapping("/create")
    public String Create() {
        return "Temporary/add";
    }

    @GetMapping("/update")
    public String Update(Integer id, ModelMap modelMap) {
        Temporary temporary = firstTestFeign.UpdateDao(id);
        modelMap.addAttribute("temporary", temporary);
        return "Temporary/edit";
    }
}
