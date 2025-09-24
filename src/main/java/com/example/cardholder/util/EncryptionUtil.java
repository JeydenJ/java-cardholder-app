package com.example.cardholder.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionUtil {

    // Hardcoded 16-character AES key
    private static final String KEY_STRING = "1234567890abcdef";
    private final SecretKeySpec keySpec;

    public EncryptionUtil() {
        keySpec = new SecretKeySpec(KEY_STRING.getBytes(), "AES");
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
}
