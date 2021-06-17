package com.java.secondtest.controller;


import com.github.pagehelper.PageHelper;
import com.java.secondtest.Calculate.SecTest;
import com.java.secondtest.entity.Sectest;
import com.java.secondtest.service.impl.SectestServiceImpl;
import com.java.utilsserver.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author luozhong
 * @since 2021-06-14
 */
@Controller
@CrossOrigin(origins = "*")
public class SectestController {
    @Autowired
    SectestServiceImpl sectestService;

    @PostMapping("/SecondTest/create")
    @ResponseBody
    public Map<String, Object> CreateDao(@RequestBody Sectest sectest) {
        LocalDateTime time = LocalDateTime.now();
        sectest.setDate(time);
        Boolean result = sectestService.save(sectest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "添加失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "添加成功").getMap();
    }

    @GetMapping("/updatedata")
    @ResponseBody
    public Sectest UpdateDao1(Integer id) // 此处带参传值用ModelMap
    {
        Sectest sectest = sectestService.getById(id);
        return sectest;
    }

    @PostMapping("/SecondTest/update")
    @ResponseBody
    public Map<String, Object> UpdateDao(@RequestBody Sectest sectest) {

        Boolean result = sectestService.updateById(sectest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "修改失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "修改成功").getMap();
    }

    @PostMapping("/SecondTest/delete")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('admin')")
    public Map<String, Object> DeleteDao(String ids) {
        String[] arr = ids.split(",");
        Boolean result = sectestService.removeByIds(Arrays.asList(arr));
        if (!result) {
            return MapParameter.getInstance().put("msg", "删除失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "删除成功").getMap();
    }

    @PostMapping("/SecondTest/query")
    @ResponseBody
    public Map<String, Object> query(Sectest sectest) {
        PageHelper.startPage(sectest.getPage(), sectest.getLimit());
        Integer count = sectestService.count(null);
        List<Sectest> list = sectestService.list(null);
        return MapParameter.getInstance().put("code", 0).put("msg", "").put("count", count).put("data", list).getMap();
    }

    @PostMapping("/SecondTest/test")
    @ResponseBody
    public Map<String, Object> tests(@RequestBody Sectest sectest) {
        Sectest sectest1 = SecTest.calculate(sectest);
        Boolean result = sectestService.save(sectest1);
        if (!result) {
            return MapParameter.getInstance().put("msg", "计算失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "计算成功").put("tvr", sectest1.getTvr()).getMap();
    }

}
