package com.yygh.hosp.controller.api;

import com.yygh.common.exception.YyghException;
import com.yygh.common.helper.HttpRequestHelper;
import com.yygh.common.result.Result;
import com.yygh.common.result.ResultCodeEnum;
import com.yygh.common.utils.MD5;
import com.yygh.hosp.service.HospitalService;
import com.yygh.hosp.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName : ApiController  //类名
 * @Description :   //描述
 * @Author : 10079 //作者
 * @Date: 2022/6/6  12:06
 */
@RestController
@RequestMapping("api/hosp")
public class ApiController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private HospitalSetService hospitalSetService;
    //上传医院接口
    @RequestMapping("/saveHospital")
    public Result saveHosp(HttpServletRequest request){
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        String hospSign = (String) paramMap.get("sign");
        String hospcode = (String) paramMap.get("hoscode");
        String signKey = hospitalSetService.getSignKey(hospcode);
        String encrypt = MD5.encrypt(signKey);
        if (!hospSign.equals(encrypt)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
        hospitalService.save(paramMap);
        return Result.ok();
    }
}
