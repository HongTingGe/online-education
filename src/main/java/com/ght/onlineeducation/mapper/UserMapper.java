package com.ght.onlineeducation.mapper;

import com.ght.onlineeducation.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 根据数据库主键查找用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findById(@Param("id") int userId);


    /**
     * 根据openid查找用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    public User findByOpenid(@Param("openid") String openid);


    @Insert("INSERT INTO `user` (`openid`, `name`, `head_img`,`sex`, `city`, `create_time`)" +
            "VALUES" +
            "(#{openid} , #{name} , #{headImg} , #{sex} ,#{city} ,#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int save(User user);
}
