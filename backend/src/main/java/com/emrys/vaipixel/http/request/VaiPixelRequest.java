package com.emrys.vaipixel.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class VaiPixelRequest {
    @JsonProperty("t")
    private long timestamp;
    @JsonProperty("e")
    private int encryptionCode;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getEncryptionCode() {
        return encryptionCode;
    }

    public void setEncryptionCode(int encryptionCode) {
        this.encryptionCode = encryptionCode;
    }
}
