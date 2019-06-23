package com.emrys.vaipixel.dto.cond;

import com.emrys.vaipixel.db.enums.WorkStatusEnum;
import com.emrys.vaipixel.db.enums.WorkTypeEnum;

public class WorkCond {
    private long categoryId;
    private String title;
    private WorkTypeEnum type;
    private WorkStatusEnum status;
    private long startTime;
    private long endTime;

    private WorkCond(Builder builder) {
        categoryId = builder.categoryId;
        title = builder.title;
        type = builder.type;
        status = builder.status;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public WorkTypeEnum getType() {
        return type;
    }

    public WorkStatusEnum getStatus() {
        return status;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public static final class Builder {
        private long categoryId;
        private String title;
        private WorkTypeEnum type;
        private WorkStatusEnum status;
        private long startTime;
        private long endTime;

        public Builder() {
        }

        public Builder withCategoryId(long val) {
            categoryId = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withType(WorkTypeEnum val) {
            type = val;
            return this;
        }

        public Builder withStatus(WorkStatusEnum val) {
            status = val;
            return this;
        }

        public Builder withStartTime(long val) {
            startTime = val;
            return this;
        }

        public Builder withEndTime(long val) {
            endTime = val;
            return this;
        }

        public WorkCond build() {
            return new WorkCond(this);
        }
    }
}
