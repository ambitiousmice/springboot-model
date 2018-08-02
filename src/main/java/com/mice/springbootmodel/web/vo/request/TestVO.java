package com.mice.springbootmodel.web.vo.request;


import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: ChenHao
 * @Date: 2018/5/23 16:48
 */
public class TestVO {
    @NotEmpty(message = "test不能为空")
    private String test1;
    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

}
