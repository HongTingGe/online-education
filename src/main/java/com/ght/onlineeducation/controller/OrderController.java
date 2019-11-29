package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.domain.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/order")
public class OrderController {

    @GetMapping("/add")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("下单成功!");
    }
}
