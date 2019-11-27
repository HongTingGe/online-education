package com.ght.onlineeducation.mapper;

import com.ght.onlineeducation.domain.Video;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    @Select("select * from video")
    public List<Video> findAll();
}
