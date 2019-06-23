package com.emrys.vaipixel.service.works;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.WorkException;
import com.emrys.vaipixel.service.works.imp.PhotoEditorImp;
import com.emrys.vaipixel.service.works.imp.VideoEditorImp;

public interface IWorkEditor {
    void addWork(Work work);

    void updateWork(Work work);

    static IWorkEditor processWork(Work work) {
        WorkTypeEnum type = work.getType();
        switch (type) {
            case video:
                return new VideoEditorImp();
            case photo:
                return new PhotoEditorImp();
            default:
                throw new WorkException();
        }
    }
}
