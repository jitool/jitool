package com.dreamf.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 注：
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/19 8:53
 */
public class FtpUtils {
    private static final Logger log = LoggerFactory.getLogger(FtpUtils.class);
    private ThreadLocal<FTPClient> ftpPool = new ThreadLocal<>();
    private String host;
    private Integer port;
    private String username;
    private String password;

    public FtpUtils(String host, Integer port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    private FTPClient connect() {
        if(this.ftpPool.get() != null && this.ftpPool.get().isConnected()) {
            return this.ftpPool.get();
        }
        FTPClient client = null;
        try {
            client = new FTPClient();
            client.setControlEncoding("UTF-8");
            client.connect(this.host, this.port);
            int replyCode = client.getReplyCode();
            if(FTPReply.isPositiveCompletion(replyCode)) {
                if(client.login(this.username,this.password)) {
                    this.ftpPool.set(client);
                    return client;
                }
            }else {
                client.disconnect();
                log.error("login error,ftp server no find username,so disconnect");
            }
        }catch (IOException e) {
            if(client.isConnected()) {
                try {
                    client.disconnect();
                }catch (IOException io) {
                    log.error("disconnect error: {}",io.getMessage());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FTPClient utils = new FtpUtils("127.0.0.1",21,"user","pass").connect();
    }

}
