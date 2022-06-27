package com.shusheng.config;

import com.shusheng.commons.R;
import com.shusheng.utils.ResultUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

/**
 * 对校验信息进行拦截
 * @author 刘闯
 * @date 2021/3/20.
 */

@RestControllerAdvice
public class BadRequestExceptionHandler {

    /**
     * 自定义拦截内容
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R bingExceptionHandler(MethodArgumentNotValidException  e){
        BindingResult bindingResult =  e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        assert fieldError != null;
        return ResultUtils.error(fieldError.getDefaultMessage());
    }

    /**
     * 数据操作异常处理
     * @param e 异常参数
     * @return R
     */
    @ExceptionHandler(DataAccessException.class)
    public R bingExceptionHandler(DataAccessException e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("SQL异常！请联系管理员！");
    }

    /**
     * SQL异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(NullPointerException.class)
    public R bingExceptionHandler(NullPointerException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("空指针异常！请联系管理员！");
    }

    /**
     * 数组越界异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public R bingExceptionHandler(IndexOutOfBoundsException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("数组越界异常！请联系管理员！");
    }

    /**
     * 类型转换异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(ClassCastException.class)
    public R bingExceptionHandler(ClassCastException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("类型转换异常！请联系管理员！");
    }

    /**
     * IO异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(IOException.class)
    public R bingExceptionHandler(IOException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("IO异常！请联系管理员！");
    }

    /**
     * IO异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R bingExceptionHandler(IllegalArgumentException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("参数异常！请联系管理员！");
    }

    /**
     * IO异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(FileNotFoundException.class)
    public R bingExceptionHandler(FileNotFoundException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("文件处理异常！请联系管理员！");
    }

    /**
     * 参数格式处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R bingExceptionHandler(HttpMessageNotReadableException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("JSON格式异常！请联系管理员！");
    }


    /**
     * 运行异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(RuntimeException.class)
    public R bingExceptionHandler(RuntimeException  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("服务器异常！请联系管理员！");
    }

    /**
     * 全局异常处理
     * @param e 异常信息
     * @return R
     */
    @ExceptionHandler(Exception.class)
    public R bingExceptionHandler(Exception  e){
        System.out.println("错误日志 = " + e.getMessage());
        return ResultUtils.error("服务器异常！请联系管理员！");
    }


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public R bizExceptionHandler(BaseException e) {
        // 自定义返回错误数据
        return ResultUtils.error(e.getCode(), e.getMsg());
    }
}
