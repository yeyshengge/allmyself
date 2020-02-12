package com.zps.exception;

import com.alibaba.dubbo.rpc.RpcException;
import com.zps.entity.Result;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zps on 2019/12/28 9:33
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    /**
     * 处理所有不可知异常
     *
     * @return json结果
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String handleException(Exception e) {
        // 打印异常堆栈信息

        return "o做除数";
    }
    @ExceptionHandler(SessionAuthenticationException.class)
    @ResponseBody
    public String MySessionAuthenticationException(Exception e){
        return "您已在别个地方登陆";
    }

    /**
     * 自定义远程连接错误
     * @param e
     * @return
     */
    @ExceptionHandler(RpcException.class)
    @ResponseBody
    public Result MyRpcException(Exception e){
        return new Result(false,"404错误");
    }

}

