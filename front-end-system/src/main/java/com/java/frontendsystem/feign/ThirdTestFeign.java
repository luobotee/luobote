package com.java.frontendsystem.feign;

import com.java.thirdtest.entity.Thirtest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "THIRD-TEST")
public interface ThirdTestFeign {
    @GetMapping("/updatedata")
    Thirtest UpdateDao1(@RequestParam("id") Integer id);
}
