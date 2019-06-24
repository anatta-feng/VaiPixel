package com.emrys.vaipixel.dto.cond;

import com.emrys.vaipixel.db.enums.WorkStatusEnum;
import com.emrys.vaipixel.db.enums.WorkTypeEnum;

public class WorkCond {
    private Long categoryId;
    private String title;
    private WorkTypeEnum type;
    private WorkStatusEnum status;
    private Long startTime;
    private Long endTime;

    private WorkCond(Builder builder) {
        categoryId = builder.categoryId;
        title = builder.title;
        type = builder.type;
        status = builder.status;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public Long getCategoryId() {
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

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public static final class Builder {
        private Long categoryId;
        private String title;
        private WorkTypeEnum type;
        private WorkStatusEnum status;
        private Long startTime;
        private Long endTime;

        public Builder() {
        }

        public Builder withCategoryId(Long val) {
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

        public Builder withStartTime(Long val) {
            startTime = val;
            return this;
        }

        public Builder withEndTime(Long val) {
            endTime = val;
            return this;
        }

        public WorkCond build() {
            return new WorkCond(this);
        }
    }
}
