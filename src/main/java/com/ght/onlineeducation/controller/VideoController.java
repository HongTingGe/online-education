package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.domain.Video;
import com.ght.onlineeducation.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/find/all")
    public List<Video> pageVideo(@RequestParam(value = "page",defaultValue = "1")int page,
                                 @RequestParam(value = "size",defaultValue = "10")int size){
        return videoService.findAll();
    }

    @GetMapping("/find/{id}")
    public Video findById(@PathVariable(name = "id") int videoId){
        return videoService.findById(videoId);
    }

}
