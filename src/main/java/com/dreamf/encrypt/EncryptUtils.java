package com.dreamf.encrypt;

import com.dreamf.constant.CharsetEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.Base64;

/**
 * TODO：该模块为数据加密层，目前还有缺陷，待优化中
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/23 13:17
 */
public class EncryptUtils {
    private static final Logger log = LoggerFactory.getLogger(EncryptUtils.class);

    public static String encryptSingleData(String data, String path) {
        return encrypt(data, CertUtils.getPublicKey(path));
    }

    public static String encrypt(String data, PublicKey key) {
        try {
            byte[] encrypt = encrypt(key, data.getBytes(CharsetEnum.UTF_8.getValue()));
            return new String(Base64.getEncoder().encode(encrypt), CharsetEnum.UTF_8.getValue());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(PublicKey key, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
