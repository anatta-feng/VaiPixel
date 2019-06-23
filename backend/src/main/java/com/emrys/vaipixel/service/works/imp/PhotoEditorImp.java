package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.service.works.IWorkEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhotoEditorImp implements IWorkEditor<Photo> {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public void addWork(Photo work) {
        workMapper.insertWork(work);
        photoMapper.insertPhoto(work);
    }

    @Override
    public void updateWork(Photo work) {
    }
}
