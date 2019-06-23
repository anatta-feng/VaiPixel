package com.emrys.vaipixel.exception;

import com.emrys.vaipixel.db.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.emrys.vaipixel.constant.Constant.ErrorCode.FAIL;


public class VaiException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(VaiException.class);
    protected int errorCode;
    protected String[] errorMessageArguments;
    private ApiResponse apiResponse;

    public VaiException() {
        this("");
    }

    public VaiException(String message) {
        this(message, null);
    }

    public VaiException(int errorCode, String errorMessageArguments) {
        this.errorCode = errorCode;
        this.errorMessageArguments = new String[]{errorMessageArguments};
    }

    public VaiException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = FAIL;
        this.errorMessageArguments = new String[0];
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getErrorMessageArguments() {
        return errorMessageArguments;
    }

    public void setErrorMessageArguments(String[] errorMessageArguments) {
        this.errorMessageArguments = errorMessageArguments;
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public static VaiException withErrorCode(int errorCode) {
        VaiException exception = new VaiException();
        exception.setErrorCode(errorCode);
        return exception;
    }

    public static VaiException fromApiResponse(ApiResponse response) {
        VaiException exception = new VaiException();
        if (response == null) {
            response = ApiResponse.fail("NULL");
        }
        exception.setApiResponse(response);
        return exception;
    }
}
