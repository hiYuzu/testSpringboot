package com.sinosoft.demo.util;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/7/26 10:40
 */
public class MysqlEncryptUtil {
    private final SecretKeySpec secretKey;

    public MysqlEncryptUtil(String strKey) {
        this.secretKey = this.generateMysqlAesKey(strKey);
    }

    public String encrypt(String content) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, this.secretKey);
            byte[] cleartext = content.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(Hex.encodeHex(ciphertextBytes));
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public String decrypt(String content) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, this.secretKey);
            byte[] cleartext = Hex.decodeHex(content.toCharArray());
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(ciphertextBytes, StandardCharsets.UTF_8);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    private SecretKeySpec generateMysqlAesKey(String key) {
        byte[] finalKey = new byte[16];
        int i = 0;
        byte[] var4 = key.getBytes(StandardCharsets.US_ASCII);

        for (byte b : var4) {
            int var10001 = i++;
            finalKey[var10001 % 16] ^= b;
        }

        return new SecretKeySpec(finalKey, "AES");
    }
}
