package com.emrys.vaipixel.http.response;

public class UploadAuthResponse extends VaiPixelResponse {
    private String token;

    public UploadAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
