package com.emrys.vaipixel.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionUtilsTest {

    @Test
    public void encryptionNum() {
        EncryptionUtils.encryptionNum(138);
    }

    @Test
    public void decryptNum() {
        EncryptionUtils.decryptNum(620);
    }
}