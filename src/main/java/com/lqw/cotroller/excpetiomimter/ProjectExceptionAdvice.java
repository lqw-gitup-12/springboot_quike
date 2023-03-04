package com.lqw.cotroller.excpetiomimter;

import com.lqw.cotroller.Result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doExceotion(Exception ex)
    {
        //记录日志；
        //发送信息给运维
        //发送邮件给开发人员
        ex.printStackTrace();
        return new Result(false,"系统错误请稍后在尝试");
    }
}
