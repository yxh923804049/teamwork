package com.hg.teamwork.handler;

import com.hg.teamwork.common.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 *
 * @Author zzb
 * @Date
 */
@RestControllerAdvice
@Slf4j
public class ServerExceptionHandler {

    @ExceptionHandler({IncorrectCredentialsException.class, AuthenticationException.class})
    public AjaxResult<?> handleAuthorizationException(IncorrectCredentialsException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error("账号密码不正确");
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error("服务器异常");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult<?> handleNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error("不支持的请求方法");
    }

    @ExceptionHandler(BindException.class)
    public AjaxResult<?> bindException(HttpServletRequest request, BindingResult result, Exception ex) {
        StringBuilder builder = new StringBuilder();
        // 如果存在错误
        if (result.hasErrors()) {
            // 往错误消息中添加对象级错误
            for (ObjectError error : result.getGlobalErrors()) {
                String errorMessage = String.format("%s: %s; ", error.getObjectName(), error.getDefaultMessage());
                builder.append(errorMessage);
            }
            // 往错误消息中添加字段级错误
            for (FieldError error : result.getFieldErrors()) {
                String errorMessage;
                if (error.isBindingFailure()) {
                    // 数据绑定失败，默认信息会暴露太多细节，替换为自定义信息
                    errorMessage = String.format("%s: 参数错误; ", error.getField());
                } else {
                    // 数据校验不通过，返回默认信息
                    errorMessage = String.format("%s: %s; ", error.getField(), error.getDefaultMessage());
                }
                builder.append(errorMessage);
            }
        }
        log.info(String.format("拒绝访问。非法参数: %s -> %s", request.getServletPath(), builder.toString()));

        return AjaxResult.error(builder.toString());
    }


}
