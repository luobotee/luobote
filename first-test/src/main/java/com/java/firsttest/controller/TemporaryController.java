package com.java.firsttest.controller;


import com.github.pagehelper.PageHelper;
import com.java.firsttest.entity.Temporary;
import com.java.firsttest.service.impl.TemporaryServiceImpl;
import com.java.utilsserver.GetData;
import com.java.utilsserver.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class TemporaryController {
    @Autowired
    TemporaryServiceImpl temporaryService;

    @PostMapping("/TemporaryTest/create")
    @ResponseBody
    public Map<String, Object> CreateDao(@RequestBody Temporary temporary) {
        LocalDateTime time = LocalDateTime.now();
        temporary.setDate(time);
        Boolean result = temporaryService.save(temporary);
        if (!result) {
            return MapParameter.getInstance().put("msg", "添加失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "添加成功").getMap();
    }


    @PostMapping("/TemporaryTest/update")
    @ResponseBody
    public Map<String, Object> UpdateDao(@RequestBody Temporary temporary) {

        Boolean result = temporaryService.updateById(temporary);
        if (!result) {
            return MapParameter.getInstance().put("msg", "修改失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "修改成功").getMap();
    }


    @PostMapping("/TemporaryTest/delete")
    @ResponseBody
    public Map<String, Object> DeleteDao(String ids) {
        String[] arr = ids.split(",");
        Boolean result = temporaryService.removeByIds(Arrays.asList(arr));
        if (!result) {
            return MapParameter.getInstance().put("msg", "删除失败").getMap();
        }
        return MapParameter.getInstance().put("msg", "删除成功").getMap();
    }

    @PostMapping("/TemporaryTest/query")
    @ResponseBody
    public Map<String, Object> query(Temporary temporary) {
        PageHelper.startPage(temporary.getPage(), temporary.getLimit());
        Integer count = temporaryService.count(null);
        List<Temporary> list = temporaryService.list(null);
        return MapParameter.getInstance().put("code", 0).put("msg", "").put("count", count).put("data", list).getMap();
    }

    @PostMapping("/TemporaryTest/details")
    @ResponseBody
    public Map<String, Object> details(@RequestBody String ids) {
        List<Temporary> list = temporaryService.list(null);
        return MapParameter.getInstance().put("data", list).getMap();
    }

    @PostMapping("/TemporaryTest/finish")
    @ResponseBody
    public Map<String, Object> finish() {
        int result1 = temporaryService.create();
        if (result1 != 0) {
            Boolean result = temporaryService.remove(null);
            if (!result) {
                return MapParameter.getInstance().put("msg", "发生错误请重试").getMap();
            }
            return MapParameter.getInstance().put("msg", "实验结束，数据已保存，谢谢使用").getMap();
        }
        return null;
    }

    @PostMapping("/TemporaryTest/data")
    @ResponseBody
    public Map<String, Object> date(@RequestBody String data) {
        Boolean result = true;
        Temporary temporary = new Temporary();
        String str = GetData.readTxtFile(data);
        String[] arr = str.split("\\s+");
        for (String ss : arr) {
            Double g = Double.parseDouble(ss);
            temporary.setG(g);
            result = temporaryService.save(temporary);
        }
        if (!result) {
            return MapParameter.getInstance().put("msg", "导入失败，请检查路径是否正确").getMap();
        }
        return MapParameter.getInstance().put("msg", "导入成功,请刷新页面").getMap();
    }
}
