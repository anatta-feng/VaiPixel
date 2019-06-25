package com.emrys.vaipixel.constant;

public class Constant {

    public enum ErrorStatus {
        SUCCESS(1000, "SUCCESS"),
        FAIL(2000, "Fail"),
        FAIL_REQUEST_PARAM(2100, "Request param error"),
        FAIL_WORK_ALREADY_EXIST(2101, "Work already exist"),
        FAIL_WORK_NOT_EXIST(2102, "Work not exist"),
        FAIL_USER_ALREADY_EXIST(2103, "User already exist"),
        FAIL_USER_NOT_EXIST(2104, "User not exist");

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
