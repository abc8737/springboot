package com.springboot.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Security;

/**
 * 密码加密方式
 * Created by SYSTEM on 2018/7/15.
 */
public class EncryptUtil {

    public static String encrypt(String encryPattern, String rowPassword) throws Exception {
        String encryPassword = "";
        MessageDigest digest = MessageDigest.getInstance(encryPattern);
        switch (encryPattern) {
            case "MD5":
                encryPassword = MD5Encoder.encode(digest.digest(rowPassword.getBytes("utf-8")));
                break;
            case "SHA256":

                break;
        }
        return encryPassword;
    }
}
