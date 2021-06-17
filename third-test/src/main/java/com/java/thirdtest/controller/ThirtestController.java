package com.java.thirdtest.controller;


import com.github.pagehelper.PageHelper;
import com.java.thirdtest.Calculate.ThirTest;
import com.java.thirdtest.entity.Thirtest;
import com.java.thirdtest.service.impl.ThirtestServiceImpl;
import com.java.utilsserver.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ThirtestController {
    @Autowired
    ThirtestServiceImpl thirtestService;


    @PostMapping("/Third/create")
    @ResponseBody
    public Map<String, Object> CreateDao(@RequestBody Thirtest sectest) {
        LocalDateTime time = LocalDateTime.now();
        sectest.setDate(time);
        Boolean result = thirtestService.save(sectest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "添加失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "添加成功").getMap();
    }

    @GetMapping("/updatedata")
    @ResponseBody
    public Thirtest UpdateDao1(Integer id) // 此处带参传值用ModelMap
    {
        Thirtest thirtest = thirtestService.getById(id);
        return thirtest;
    }

    @PostMapping("/Third/update")
    @ResponseBody
    public Map<String, Object> UpdateDao(@RequestBody Thirtest thirtest) {

        Boolean result = thirtestService.updateById(thirtest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "修改失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "修改成功").getMap();
    }

    @PostMapping("/Third/delete")
    @ResponseBody
    public Map<String, Object> DeleteDao(String ids) {
        String[] arr = ids.split(",");
        Boolean result = thirtestService.removeByIds(Arrays.asList(arr));
        if (!result) {
            return MapParameter.getInstance().put("msg", "删除失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "删除成功").getMap();
    }

    @PostMapping("/Third/query")
    @ResponseBody
    public Map<String, Object> query(Thirtest thirtest) {
        PageHelper.startPage(thirtest.getPage(), thirtest.getLimit());
        Integer count = thirtestService.count(null);
        List<Thirtest> list = thirtestService.list(null);
        return MapParameter.getInstance().put("code", 0).put("msg", "").put("count", count).put("data", list).getMap();
    }

    @PostMapping("/Third/test")
    @ResponseBody
    public Map<String, Object> tests(@RequestBody Thirtest thirtest) {
        Thirtest thirtest1 = ThirTest.calculate(thirtest);
        Boolean result = thirtestService.save(thirtest1);
        if (!result) {
            return MapParameter.getInstance().put("msg", "计算失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "计算成功").put("sl", thirtest1.getSl()).getMap();
    }

}
