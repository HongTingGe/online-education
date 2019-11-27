package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.domain.Video;
import com.ght.onlineeducation.service.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/find/all")
    public Object pageVideo(@RequestParam(value = "page",defaultValue = "1")int page,
                                 @RequestParam(value = "size",defaultValue = "10")int size){

        PageHelper.startPage(page, size);
        List<Video> list = videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("total_size",pageInfo.getTotal());
        map.put("total_page",pageInfo.getPages());
        map.put("current_page",page);
        return map;
    }

    @GetMapping("/find/{id}")
    public Video findById(@PathVariable(name = "id") int videoId){
        return videoService.findById(videoId);
    }

}
