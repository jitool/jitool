package com.dreamf.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO：该模块为证书管理层，目前还有缺陷，待优化中
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/23 13:18
 */

public class CertUtils {
    private static final Logger log = LoggerFactory.getLogger(CertUtils.class);
    protected static final Map<String, X509Certificate> CERT_MAP = new HashMap<>(0);
    protected static final Map<String, KeyStore> KEY_STORE_MAP = new HashMap<>(0);

    /**
     * @param path
     * @return
     */
    public static PublicKey getPublicKey(String path) {
        X509Certificate x509 = getX509Certificate(path);
        if(null != x509) {
            return x509.getPublicKey();
        }
        return null;
    }

    /**
     * @param name
     * @return
     */
    public static String getCertSerialNumber(String name) {
        if (null != CERT_MAP.get(name)) {
            throw new RuntimeException("X509Certificate not find any content for your use key");
        }
        return CERT_MAP.get(name).getSerialNumber().toString();
    }

    /**
     * @param name
     * @param path
     */
    public static void setX509Certificate(String name, String path) {
        X509Certificate x509 = getX509Certificate(path);
        if(null == x509) {
            throw new RuntimeException("X509Certificate not find any content");
        }
        CERT_MAP.put(name,x509);
    }

    public static X509Certificate getX509Certificate(String path) {
        X509Certificate certificate = null;
        CertificateFactory cf;
        InputStream in;
        try {
            in = new FileInputStream(path);
            cf = CertificateFactory.getInstance("X.509", "BC");
            certificate = (X509Certificate) cf.generateCertificate(in);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return certificate;
    }

}
