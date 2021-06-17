package com.java.frontendsystem.feign;

import com.java.secondtest.entity.Sectest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "SECOND-TEST")
public interface SecondTestFeign {

    @GetMapping("/updatedata")
    Sectest UpdateDao1(@RequestParam("id") Integer id);
}
