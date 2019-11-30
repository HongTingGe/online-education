package com.ght.onlineeducation.exception;

import com.ght.onlineeducation.domain.JsonData;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public JsonData handler1(Exception exception){

        if (exception instanceof MyException){
            MyException myException = (MyException) exception;
            return JsonData.buildError(myException.getMsg(),myException.getCode());
        } else {
            return JsonData.buildError("System Error.");
        }
    }
}
