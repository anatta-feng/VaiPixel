package com.emrys.vaipixel.mapper;


import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.mapper.VideoMapper;
import com.emrys.vaipixel.db.model.Video;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VideoMapperTest extends BaseTest {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void testQuery() {
        Video videoInfo = videoMapper.getVideoInfoByWorkId(2);
        System.out.println(videoInfo);
    }
}
