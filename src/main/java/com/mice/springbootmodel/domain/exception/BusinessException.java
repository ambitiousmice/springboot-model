package com.mice.springbootmodel.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Author: ChenHao
 * @Date: 2018/5/14 17:40
 */
@ControllerAdvice
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 2332608236621015980L;
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

    private String code;
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
