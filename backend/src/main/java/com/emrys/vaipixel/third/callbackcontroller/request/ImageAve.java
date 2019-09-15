package com.emrys.vaipixel.third.callbackcontroller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageAve {
    @JsonProperty("RGB")
    private String rgb;

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
