package com.emrys.vaipixel.db.model;

import com.emrys.vaipixel.constant.Constant;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.SUCCESS;

public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Constant.ErrorStatus status) {
        setStatus(status);
    }

    public ApiResponse(Constant.ErrorStatus status, T data) {
        setStatus(status);
        this.data = data;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setStatus(Constant.ErrorStatus code) {
        setCode(code.code());
        setMessage(code.message());
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

    public static ApiResponse fail(Constant.ErrorStatus status) {
        return withStatus(status);
    }

    public static ApiResponse withStatus(Constant.ErrorStatus status) {
        return new ApiResponse(status);
    }
}
