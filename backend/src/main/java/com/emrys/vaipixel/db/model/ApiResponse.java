package com.emrys.vaipixel.db.model;

import static com.emrys.vaipixel.constant.Constant.ErrorCode.FAIL;
import static com.emrys.vaipixel.constant.Constant.ErrorCode.SUCCESS;

public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int code) {
        this.code = code;
    }

    public ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS, data);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(FAIL, message);
    }

    public static ApiResponse withCode(int errorCode) {
        return new ApiResponse(errorCode);
    }
}
