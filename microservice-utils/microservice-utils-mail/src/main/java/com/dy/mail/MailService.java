package com.dy.mail;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.mail.SimpleMailMessage;

/**
 * 邮件服务
 * 
 * @author dy 2020年8月24日
 */
public interface MailService {

	/**
	 * 发送文本邮件 send
	 * 
	 * @param subject   主题
	 * @param text      内容
	 * @param receivers 接收人
	 * @return
	 * @author dy 2020年8月24日
	 */
	default void send(String subject, String text, String... receivers) {
		send(subject, text, null, receivers);
	}

	/**
	 * 发送message send
	 * 
	 * @param message 邮件内容
	 * @return
	 * @author dy 2020年8月24日
	 */
	void send(SimpleMailMessage message);

	/**
	 * 根据邮件配置信息发送邮件 send
	 * 
	 * @param text
	 * @return
	 * @author dy 2020年8月24日
	 */
	default void send(String text) {
		send(null, text, new String[0]);
	}

	/**
	 * 发送包含文本、图片、附件的邮件 send
	 * 
	 * @param subject   主题
	 * @param text      文本
	 * @param picPath   图片地址
	 * @param picId     图片id
	 * @param filePath  附件地址
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	default void send(String subject, String text, String picPath, String picId, String filePath, String... receivers) {
		String[] picPaths = null;
		if(StringUtils.isNotBlank(picPath)) {
			picPaths = new String[] { picPath };
		}
		String[] picIds = null;
		if(StringUtils.isNotBlank(picId)) {
			picIds = new String[] { picId };
		}
		String[] filePaths = null;
		if(StringUtils.isNotBlank(filePath)) {
			filePaths = new String[] { filePath };
		}
		send(subject, text, picPaths, picIds, filePaths, receivers);
	}

	/**
	 * 发送包含文本、图片、附件的邮件 send
	 * 
	 * @param subject   主题
	 * @param text      文本
	 * @param picPaths  图片地址
	 * @param picIds    图片id
	 * @param filePaths 附件地址
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	void send(String subject, String text, String[] picPaths, String[] picIds, String[] filePaths, String... receivers);

	/**
	 * 发送包含文本、图片的邮件 send
	 * 
	 * @param subject   主题
	 * @param text      文本
	 * @param picPaths  图片地址
	 * @param picIds    图片id
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	default void send(String subject, String text, String[] picPaths, String[] picIds, String... receivers) {
		send(subject, text, picPaths, picIds, receivers);
	}

	/**
	 * 发送包含文本附件的邮件 send
	 * 
	 * @param subject   主题
	 * @param text      文本
	 * @param filePaths 附件地址
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	default void send(String subject, String text, String[] filePaths, String... receivers) {
		send(subject, text, null, null, filePaths, receivers);
	}

	/**
	 * 发送非纯文本邮件 send
	 * 
	 * @param message
	 * @author dy 2020年8月24日
	 */
	void send(MimeMessage message);

	/**
	 * 根据配置信息发送html邮件 sendHtml
	 * 
	 * @param text
	 * @author dy 2020年8月24日
	 */
	default void sendHtml(String text) {
		sendHtml(text,null);
	}

	/**
	 * 发送html邮件 sendHtml
	 * 
	 * @param text      邮件内容
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	default void sendHtml(String text, String... receivers) {
		sendHtml(null, text, receivers);
	}

	/**
	 * 发送html邮件 sendHtml
	 * 
	 * @param subject   主题
	 * @param text      邮件内容
	 * @param receivers 接收人
	 * @author dy 2020年8月24日
	 */
	void sendHtml(String subject, String text, String... receivers);

}
