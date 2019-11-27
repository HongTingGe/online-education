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
    public List<Video> findAll(){
        return videoService.findAll();
    }

    @GetMapping("/find/{id}")
    public Video findById(@PathVariable(name = "id") int videoId){
        return videoService.findById(videoId);
    }

    @PutMapping("/update")
    public int update(Video video){
        return videoService.update(video);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable(name = "id") int videoId){
        return videoService.delete(videoId);
    }

    @PostMapping("/save")
    public int save(Video video){
        videoService.save(video);
        int rowIndex = video.getId();
        System.out.println("key---"+rowIndex);
        return rowIndex;
    }
}
