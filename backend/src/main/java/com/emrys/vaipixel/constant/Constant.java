package com.emrys.vaipixel.constant;

public class Constant {

    public enum ErrorStatus {
        SUCCESS(1000, "SUCCESS"),

        FAIL(2000, "Fail"),

        // 请求部分出错 2001～3999
        FAIL_REQUEST_PARAM(2001, "Request param error"),

        // 作品出错 2100～2199
        FAIL_WORK_ALREADY_EXIST(2101, "Work already exist"),
        FAIL_WORK_NOT_EXIST(2102, "Work not exist"),

        // 用户出错 2200～2299
        FAIL_USER_ALREADY_EXIST(2200, "User already exist"),
        FAIL_USER_NOT_EXIST(2201, "User not exist");

        private int code;
        private String message;
        ErrorStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }
        public int code() {
            return code;
        }
        public String message() {
            return message;
        }
    }

}
