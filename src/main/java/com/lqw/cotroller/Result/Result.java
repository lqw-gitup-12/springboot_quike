package com.lqw.cotroller.Result;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object  result;
    private String message;
    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result( boolean flag,Object result) {
        this.result = result;
        this.flag = flag;
    }

    public Result(boolean flag, Object result, String message) {
        this.flag = flag;
        this.result = result;
        this.message = message;
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result() {
    }
}
