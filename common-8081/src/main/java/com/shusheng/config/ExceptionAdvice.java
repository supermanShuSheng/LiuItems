package com.shusheng.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.shusheng.commons.R;
import com.shusheng.utils.ResultUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘闯
 * @date 2021/4/1.
 */

@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 在当前类每个方法进入之前触发的操作
     *
    */
    @ModelAttribute
    public void get(HttpServletRequest request) throws IOException {

    }

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BaseException.class)
    public R bizExceptionHandler(BaseException e) {
        return ResultUtils.error(e.getCode(), e.getMsg());
    }

    /**
     * 访问接口校验值
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
     * Token全局异常拦截
     *
    */
    @ExceptionHandler(NotLoginException.class)
    public R handlerNotLoginException(NotLoginException nle, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 打印堆栈，以供调试R
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        }
        else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return ResultUtils.error(message);
    }

//    // 全局异常拦截（拦截项目中的所有异常）
//    @ResponseBody
//    @ExceptionHandler
//    public AjaxJson handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//
//        // 打印堆栈，以供调试
//        System.out.println("全局异常---------------");
//        e.printStackTrace();
//
//        // 不同异常返回不同状态码
//        AjaxJson aj = null;
//        if (e instanceof NotLoginException) {	// 如果是未登录异常
//            NotLoginException ee = (NotLoginException) e;
//            aj = AjaxJson.getNotLogin().setMsg(ee.getMessage());
//        } else if(e instanceof NotRoleException) {		// 如果是角色异常
//            NotRoleException ee = (NotRoleException) e;
//            aj = AjaxJson.getNotJur("无此角色：" + ee.getRole());
//        } else if(e instanceof NotPermissionException) {	// 如果是权限异常
//            NotPermissionException ee = (NotPermissionException) e;
//            aj = AjaxJson.getNotJur("无此权限：" + ee.getCode());
//        } else {	// 普通异常, 输出：500 + 异常信息
//            aj = AjaxJson.getError(e.getMessage());
//        }
//
//        // 返回给前端
//        return aj;
//
//        // 输出到客户端
////		response.setContentType("application/json; charset=utf-8"); // http说明，我要返回JSON对象
////		response.getWriter().print(new ObjectMapper().writeValueAsString(aj));
//    }
}
