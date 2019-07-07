package com.emrys.vaipixel.exception;

import com.emrys.vaipixel.constant.Constant;
import com.emrys.vaipixel.db.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.FAIL;


public class VaiException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(VaiException.class);
    protected int errorCode;
    protected String errorMessageArguments;
    private ApiResponse apiResponse;

    public VaiException() {
        this(FAIL);
    }

    public VaiException(Constant.ErrorStatus status) {
        this(status, null);
    }

    public VaiException(Constant.ErrorStatus status, Throwable cause) {
        super(status.message(), cause);
        this.errorCode = FAIL.code();
        this.errorMessageArguments = FAIL.message();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageArguments() {
        return errorMessageArguments;
    }

    public void setErrorMessageArguments(String errorMessageArguments) {
        this.errorMessageArguments = errorMessageArguments;
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public static VaiException withStatus(Constant.ErrorStatus status) {
        return new VaiException(status);
    }

    public static VaiException fromApiResponse(ApiResponse response) {
        VaiException exception = new VaiException();
        if (response == null) {
            response = ApiResponse.fail(FAIL);
        }
        exception.setApiResponse(response);
        return exception;
    }
}
