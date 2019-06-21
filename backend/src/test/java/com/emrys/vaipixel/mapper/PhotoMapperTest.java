package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.CameraParameter;
import com.emrys.vaipixel.db.model.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoMapperTest {

    @Autowired
    private PhotoMapper photoMapper;

    @Test
    public void testInsert() {
        Photo photo = new Photo();
        photo.setTitle("秋名山1111");
        photo.setDescription("五菱宏光1111");

        photo.setCategoryId(1);
        photo.setAuthorId(1);
        photo.setSmallUrl("232");
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.setAperture(14);
        cameraParameter.setCamera("A6400");
        cameraParameter.setLens("50 1.4");
        photo.setCameraParameter(cameraParameter);
        photoMapper.insert(photo);
    }

    @Test
    public void testQuery() {
        List<Photo> all = photoMapper.getAll();
        System.out.println(all);
    }

}
