package com.ght.onlineeducation;

import com.ght.onlineeducation.mapper.VideoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineEducationApplicationTests {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void test1() {
        System.out.println(videoMapper.findAll());

    }

}
