package com.yygh.cmn.controller;

import com.yygh.cmn.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : DictController  //类名
 * @Description :   //描述
 * @Author : 10079 //作者
 * @Date: 2022/6/2  20:40
 */
@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {
    @Autowired
    private DictService dictService;
}
