package com.travel.web.controller;

import com.alibaba.fastjson.JSON;
import com.travel.commons.enums.ResultStatus;
import com.travel.commons.resultbean.ResultGeekQ;
import com.travel.service.MiaoShaUserService;
import com.travel.service.MiaoshaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 邱润泽 bullock
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MiaoshaService miaoshaService;

    @Autowired
    private MiaoShaUserService miaoShaUserService;
    @RequestMapping(value="/list", produces="text/html")
    @ResponseBody
    public String list() {
        List<String> list = Arrays.asList("1","2","3");
        List<String> list1 = list.stream().filter((String str)->
                str.equals("2")).collect(Collectors.toList());
        return JSON.toJSONString(list1);
    }

    @GetMapping("do_register")
    public String register() {
        return "register";
    }

    /**
     * 注册网站
     * @param userName
     * @param passWord
     * @param salt
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultGeekQ<String> register(@RequestParam("username") String userName ,
                                        @RequestParam("password") String passWord,
                                        @RequestParam("verifyCode") String verifyCode,
                                        @RequestParam("salt") String salt, HttpServletResponse response ){

        ResultGeekQ<String> result = ResultGeekQ.build();
        /**
         * 校验验证码
         */
        boolean check = miaoshaService.checkVerifyCodeRegister(Integer.valueOf(verifyCode));
        if(!check){
            result.withError(ResultStatus.CODE_FAIL.getCode(),ResultStatus.CODE_FAIL.getMessage());
            return result;

        }
        boolean registerInfo  = miaoShaUserService.register(response , userName,passWord,salt);
        if(!registerInfo){
            result.withError(ResultStatus.RESIGETER_FAIL.getCode(),ResultStatus.RESIGETER_FAIL.getMessage());
            return result;
        }
        return result;
    }
}
