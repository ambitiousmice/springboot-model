package com.mice.springbootmodel.web;


import com.mice.springbootmodel.common.Result;
import com.mice.springbootmodel.domain.exception.BusinessException;
import com.mice.springbootmodel.web.vo.request.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ChenHao
 * @Date: 2018/5/22 17:36
 */

@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody public Result test(@Validated @RequestBody TestVO testVO){
        throw new BusinessException("22","s");
    }
}
