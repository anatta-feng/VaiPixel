package com.emrys.vaipixel.db.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private long id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
