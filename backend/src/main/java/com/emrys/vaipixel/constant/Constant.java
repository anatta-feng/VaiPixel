package com.emrys.vaipixel.constant;

public class Constant {
    public static class ErrorCode {
        public static final int SUCCESS = 1000;

        public static final int FAIL = 2000;
        // 请求部分出错 2100～2199
        public static final int FAIL_REQUEST_PARAM = 2100;
        public static final int FAIL_WORK_ALREADY_EXIST = 2101;
        public static final int FAIL_WORK_NOT_EXIST = 2102;
        public static final int FAIL_USER_ALREADY_EXIST = 2103;
        public static final int FAIL_USER_NOT_EXIST = 2104;
    }
}
