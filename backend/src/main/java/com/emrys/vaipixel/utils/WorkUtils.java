package com.emrys.vaipixel.utils;

import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Work;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkUtils {
    @Autowired
    private static WorkMapper workMapper;

    public static boolean isWorkExist(Work work) {
        return work == null || workMapper.getWorkById(work.getWorkId()) != null;
    }

    public static boolean isWorkExist(long workId) {
        return workMapper.getWorkById(workId) != null;
    }
}
