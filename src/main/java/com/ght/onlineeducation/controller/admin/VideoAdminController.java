package com.ght.onlineeducation.controller.admin;

import com.ght.onlineeducation.domain.Video;
import com.ght.onlineeducation.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    @PutMapping("/update")
    public int update(@RequestBody Video video){
        return videoService.update(video);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable(name = "id") int videoId){
        return videoService.delete(videoId);
    }

    @PostMapping("/save")
    public int save(@RequestBody Video video){
        videoService.save(video);
        int rowIndex = video.getId();
        System.out.println("key---"+rowIndex);
        return rowIndex;
    }
}
