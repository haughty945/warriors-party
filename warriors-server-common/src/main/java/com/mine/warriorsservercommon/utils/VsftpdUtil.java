package com.mine.warriorsservercommon.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @description: ftp文件上传工具类
 * @author: Mine.Lee
 * @create: 2019-04-09 10:26
 * @version: v1.0
 * @remark: Expect no bugs
 */
public class VsftpdUtil {

    private static String IP_ADD = "176.122.189.97";

    private static Integer PORT = 27364;

    private static String USER_NAME = "root";

    private static String PASS_WORD = "RgCnT3xZFCba";

    private static String TARGET_PATH = "/home/ftpuser/www/images/";

    /*=============*/

    private static String SSH_CONFIG_KEY = "StrictHostKeyChecking";
    private static String SSH_CONFIG_VALUE = "no";
    private static String SSH_CHANNEL_VALUE = "sftp";

    /**
     *
     * @param sourceFile  源文件                .ex:/Users/mac/66.jpeg
     * @param targetPath  目标路径              .ex:/home/ftpuser/www/images/
     * @return java.lang.String  相对路径       .ex:/home/ftpuser/www/images/66.jpeg
     */
    public static String Upload(MultipartFile sourceFile, String targetPath) {
        Channel channel = null;
        ChannelSftp sftp = null;
        Session sshSession = null;
        String relativeath = null;
        try {
            FileInputStream inputStream = (FileInputStream) sourceFile.getInputStream();
            JSch jsch = new JSch();
            jsch.getSession(USER_NAME, IP_ADD, PORT);
            sshSession = jsch.getSession(USER_NAME, IP_ADD, PORT);
            sshSession.setPassword(PASS_WORD);
            Properties sshConfig = new Properties();
            sshConfig.put(SSH_CONFIG_KEY, SSH_CONFIG_VALUE);
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel(SSH_CHANNEL_VALUE);
            channel.connect();
            sftp = (ChannelSftp) channel;
            relativeath = targetPath + sourceFile.getOriginalFilename();
            sftp.put(inputStream, relativeath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
            return relativeath;
        }
    }

    private static void closeChannel(Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
    }

    private static void closeSession(Session session) {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

}  