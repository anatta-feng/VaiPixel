package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.dao.work.IWorkDao;
import com.emrys.vaipixel.db.model.Video;
import com.emrys.vaipixel.service.works.IWorkEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoEditorImp implements IWorkEditor<Video> {

    @Autowired
    private IWorkDao workDao;

    @Override
    public void addWork(Video work) {
        workDao.addVideoWork(work);
    }

    @Override
    public void updateWork(Video work) {

    }
}
