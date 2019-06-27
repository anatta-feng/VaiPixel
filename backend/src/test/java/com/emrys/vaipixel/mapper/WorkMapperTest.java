package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.mapper.UserMapper;
import com.emrys.vaipixel.db.mapper.VideoMapper;
import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.*;
import com.emrys.vaipixel.dto.cond.WorkCond;
import com.emrys.vaipixel.utils.SnowflakeIdWorker;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkMapperTest extends BaseTest {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Test
    public void testQuery() {
        List<Work> all = workMapper.getWorks();
        for (Work work : all) {
            System.out.println(work);
        }
    }

    @Test
    public void testInsert() {
        Photo photo = new Photo();
        photo.setWorkId(idWorker.nextId());
        Category category = new Category();
        category.setCategoryId(1);
        User user = new User();
        user.setUserId(1);
        photo.setCategory(category);
        photo.setAuthor(user);
        photo.setTitle("PhotoTest");
        workMapper.insertWork(photo);
        photoMapper.insertPhoto(photo);


        Video video = new Video();
        video.setWorkId(idWorker.nextId());
        video.setCategory(category);
        video.setAuthor(user);
        video.setTitle("VideoTest");
        workMapper.insertWork(video);
        videoMapper.insertVideo(video);
    }

    @Test
    public void testQueryById() {
        Work work = workMapper.getWorkById(1);
        System.out.println(work);
    }

    @Test
    public void testCond() {
        WorkCond.Builder builder = new WorkCond.Builder();
        WorkCond build = builder
                .withCategoryId(1L)
                .withOrderBy(WorkCond.Order.ID, WorkCond.SC.ASC)
                .build();
        List<Work> worksByCond = workMapper.getWorksByCond(build);
        System.out.println(worksByCond);
    }
}
