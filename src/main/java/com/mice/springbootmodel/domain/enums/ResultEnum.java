package com.mice.springbootmodel.domain.enums;

/**
 * @Author: ChenHao
 * @Date: 2018/5/22 17:21
 */
public enum ResultEnum {

    UNKONW_ERROR("-1","未知错误"),
    LESS_PARAMS("1001","传入参数不全"),
    CODE_EXIST("1002","编码已存在"),
    BUSINESS_EXCEPTION("10003","业务异常"),
    SYSTEM_EXCEPTION("10004","系统异常"),
    SQL_EXCEPTION("10004","数据库异常"),
    SUCCESS("200","成功");

    private String code;
    private String msg;
    ResultEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}

