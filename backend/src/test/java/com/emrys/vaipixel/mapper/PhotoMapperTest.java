package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Work;
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
        List<Photo> all = photoMapper.getAll();
        System.out.println(all);

        Photo photo = new Photo();
        photo.setId(10);
        photo.setTitle("秋名山");
        photo.setDescription("五菱宏光");
        photo.setAperture(14);
        photo.setCamera("A6400");
        photo.setLens("50 1.4");
        photo.setCategoryId(1);
        photo.setAuthorId(1);
        photo.setSmallUrl("232");

        photoMapper.insert(photo);
    }

}
