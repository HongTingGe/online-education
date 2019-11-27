package com.ght.onlineeducation.mapper;

import com.ght.onlineeducation.domain.Video;
import com.ght.onlineeducation.provider.VideoProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {


    @Select("select * from video")
    public List<Video> findAll();

    @Select("SELECT * FROM video WHERE id = #{id}")
    public Video findById(int id);

    @UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    public int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    public int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
            "`cover_img`, `view_num`, `price`, `create_time`," +
            " `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
            ",#{online},#{point});")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int save(Video video);
}
