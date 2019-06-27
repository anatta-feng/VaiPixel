package com.emrys.vaipixel;

import com.emrys.vaipixel.utils.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SnowflakeIdWorkerTest extends BaseTest {

    @Autowired
    SnowflakeIdWorker idWorker;

    @Test
    public void testId() {
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }

}