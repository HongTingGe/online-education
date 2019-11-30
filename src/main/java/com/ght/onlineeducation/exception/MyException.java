package com.ght.onlineeducation.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private Integer code;
    private String msg;

    public MyException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
