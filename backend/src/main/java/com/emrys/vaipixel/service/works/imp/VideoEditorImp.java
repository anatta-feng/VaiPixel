package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.mapper.VideoMapper;
import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Video;
import com.emrys.vaipixel.service.works.IWorkEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoEditorImp implements IWorkEditor<Video> {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void addWork(Video work) {
        workMapper.insertWork(work);
        videoMapper.insertVideo(work);
    }

    @Override
    public void updateWork(Video work) {

    }
}
