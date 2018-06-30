package com.springboot.service;

/**
 * Created by YRP-Laptop on 2018/5/26.
 */
public interface MailService {

    /**
     * 发送简单邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleEmail(String to, String subject, String content);

    /**
     * 发送html邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filepath
     */
    void sendFileMail(String to, String subject, String content, String filepath);

    /**
     * 使用模板来发送邮件
     *
     * @param to
     * @param subject
     */
    void sendTemplateMail(String to, String subject);
}
