package com.java.frontendsystem.feign;

import com.java.firsttest.entity.Firtest;
import com.java.firsttest.entity.Temporary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "FIRST-TEST")
public interface FirstTestFeign {
    @GetMapping("/updatedata")
    Firtest UpdateDao1(@RequestParam("id") Integer id);

    @GetMapping("/updatetemporary")
    Temporary UpdateDao(@RequestParam("id") Integer id);
}
