package com.univer.base.bo;

/**
 * @author guwei
 *
 * 邮件类
 */
public class EmailBo {

    /**邮件主题*/
    private String subject;
    /**邮件内容*/
    private String content;
    /**收件人*/
    private String recipientEmail;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
}
