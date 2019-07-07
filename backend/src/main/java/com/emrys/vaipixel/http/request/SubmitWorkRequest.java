package com.emrys.vaipixel.http.request;

import com.emrys.vaipixel.db.model.Work;

public class SubmitWorkRequest extends VaiPixelRequest {
    private String key;
    private Work work;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
