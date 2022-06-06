package com.yygh.cmn.controller;

import com.atguigu.yygh.model.cmn.Dict;
import com.yygh.cmn.service.DictService;
import com.yygh.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName : DictController  //类名
 * @Description :   //描述
 * @Author : 10079 //作者
 * @Date: 2022/6/2  20:40
 */
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {
    @Autowired
    private DictService dictService;

    //导入数据字典
    @PostMapping("importData")
    public Result importDict(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    //导出数据字典接口
    @GetMapping("exportData")
    public Result exportDict(HttpServletResponse response) {
        dictService.exportDictData(response);
        return Result.ok();
    }

    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }
}
