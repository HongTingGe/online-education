package com.ght.onlineeducation.service;

import com.ght.onlineeducation.domain.Video;

import java.util.List;

public interface VideoService {

    public List<Video> findAll();

    public Video findById(int id);

    public int update(Video video);

    public int delete(int id);

    public int save(Video video);
}
