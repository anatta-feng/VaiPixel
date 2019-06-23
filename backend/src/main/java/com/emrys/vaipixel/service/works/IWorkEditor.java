package com.emrys.vaipixel.service.works;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.service.works.imp.PhotoEditorImp;
import com.emrys.vaipixel.service.works.imp.VideoEditorImp;

public interface IWorkEditor<T extends Work> {
    void addWork(T work);

    void updateWork(T work);

    static IWorkEditor<? extends Work> processWork(Work work) {
        WorkTypeEnum type = work.getType();
        switch (type) {
            case video:
                return new VideoEditorImp();
            case photo:
                return new PhotoEditorImp();
            default:
                throw new VaiException();
        }
    }
}
