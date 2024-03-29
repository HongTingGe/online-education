package com.ght.onlineeducation.service;


import com.ght.onlineeducation.dto.VideoOrderDto;

/**
 * 订单接口
 */
public interface VideoOrderService {

    /**
     * 下单接口
     * @param videoOrderDto
     * @return
     */
    String save(VideoOrderDto videoOrderDto) throws Exception;

}
