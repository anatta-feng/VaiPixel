package com.emrys.vaipixel.mapper;


import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.Photo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PhotoMapperTest extends BaseTest {

    @Autowired
    private PhotoMapper photoMapper;

    @Test
    public void testQuery() {
        Photo photoInfo = photoMapper.getPhotoInfoByWorkId(1);
        System.out.println(photoInfo);
    }
}
