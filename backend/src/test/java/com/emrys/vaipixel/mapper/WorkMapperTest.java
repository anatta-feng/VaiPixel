package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkMapperTest {

    @Autowired
    private PhotoMapper workMapper;

    @Test
    public void testInsert() {
        Work work = new Work();
        work.setDescription("Des");
        workMapper.insert(work);
    }

}
