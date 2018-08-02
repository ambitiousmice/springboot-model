package com.mice.springbootmodel.domain.exception;

/**
 * @Author: ChenHao
 * @Date: 2018/5/15 16:37
 */

import com.mice.springbootmodel.common.Result;
import com.mice.springbootmodel.domain.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 全局异常处理器
 * @author chenhao
 */
@Order(-1000)
@ControllerAdvice
public class ExceptionResolver implements HandlerExceptionResolver {
    /**日志log*/
    private static Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

    //系统抛出的异常
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行的Handler对象(只有method)
        //解析出异常类型。
        /*  使用response返回    */
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        //如果该 异常类型是系统 自定义的异常，直接取出异常信息。
        try {
            Result result = new Result();
            if(ex instanceof BusinessException){
                BusinessException businessException = (BusinessException)ex;
                result = resolverBusinessException(ex);
            }else if(ex instanceof MethodArgumentNotValidException){
                MethodArgumentNotValidException businessException = (MethodArgumentNotValidException)ex;
                result = resolverMethodArgumentNotValidException(ex);
            }else if(ex instanceof SQLException){
                SQLException sqlException = (SQLException)ex;
                result = resolverSQLException(ex);
            }else {
                result = resolverOtherException(ex);
            }
            //错误信息
            log.error(ex.getMessage(),ex);
            response.getWriter().write(result.toString());
        } catch (IOException e) {
            log.error("与客户端通讯异常:"+ e.getMessage(), e);
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView();

        return modelAndView;
    }

    /*
     * 处理业务层异常
     */
    private Result resolverBusinessException(Exception ex) {
        BusinessException businessException = (BusinessException) ex;
        return Result.error(businessException.getCode(),businessException.getMessage());
    }

    /*
     * 处理参数绑定异常
     */
    private Result resolverMethodArgumentNotValidException(Exception ex) {
        MethodArgumentNotValidException be = (MethodArgumentNotValidException) ex;
        StringBuilder sb = new StringBuilder();
        List<FieldError> errorList = be.getBindingResult().getFieldErrors();
        for (FieldError error : errorList) {
            sb.append(error.getDefaultMessage()+",");
        }
        return Result.error(ResultEnum.LESS_PARAMS.getCode(),sb.substring(0,sb.length()-1));
    }

    /*
     * 处理数据库异常
     */
    private Result resolverSQLException(Exception ex) {
        SQLException be = (SQLException) ex;
        return Result.error(ResultEnum.SQL_EXCEPTION.getCode(),be.getMessage());
    }

    /*
     * 处理其他异常
     */
    private Result resolverOtherException(Exception ex) {
        return Result.error(ResultEnum.SYSTEM_EXCEPTION.getCode(),ex.getMessage());
    }


}
