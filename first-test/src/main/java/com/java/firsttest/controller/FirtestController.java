package com.java.firsttest.controller;


import com.github.pagehelper.PageHelper;
import com.java.firsttest.entity.Firtest;
import com.java.firsttest.entity.Temporary;
import com.java.firsttest.service.impl.FirtestServiceImpl;
import com.java.firsttest.service.impl.TemporaryServiceImpl;
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
public class FirtestController {
    @Autowired
    FirtestServiceImpl firtestService;
    @Autowired
    TemporaryServiceImpl temporaryService;

    @PostMapping("/FirstTest/create")
    @ResponseBody
    public Map<String, Object> CreateDao(@RequestBody Firtest firtest) {
        LocalDateTime time = LocalDateTime.now();
        firtest.setDate(time);
        Boolean result = firtestService.save(firtest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "添加失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "添加成功").getMap();
    }


    @GetMapping("/updatedata")
    @ResponseBody
    public Firtest UpdateDao1(Integer id) // 此处带参传值用ModelMap
    {
        Firtest firtest = firtestService.getById(id);
        return firtest;
    }

    @GetMapping("/updatetemporary")
    @ResponseBody
    public Temporary Updatedata(Integer id) // 此处带参传值用ModelMap
    {
        Temporary temporary = temporaryService.getById(id);
        return temporary;
    }

    @PostMapping("/FirstTest/update")
    @ResponseBody
    public Map<String, Object> UpdateDao(@RequestBody Firtest firtest) {

        Boolean result = firtestService.updateById(firtest);
        if (!result) {
            return MapParameter.getInstance().put("msg", "修改失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "修改成功").getMap();
    }


    @PostMapping("/FirstTest/delete")
    @ResponseBody
    public Map<String, Object> DeleteDao(String ids) {
        String[] arr = ids.split(",");
        Boolean result = firtestService.removeByIds(Arrays.asList(arr));
        if (!result) {
            return MapParameter.getInstance().put("msg", "删除失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "删除成功").getMap();
    }


    @PostMapping("/FirstTest/query")
    @ResponseBody
    public Map<String, Object> query(Firtest firtest) {
        PageHelper.startPage(firtest.getPage(), firtest.getLimit());
        Integer count = firtestService.count(null);
        List<Firtest> list = firtestService.list(null);
        return MapParameter.getInstance().put("code", 0).put("msg", "").put("count", count).put("data", list).getMap();
    }

}
