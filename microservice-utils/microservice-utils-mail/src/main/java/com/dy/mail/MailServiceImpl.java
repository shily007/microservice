package com.dy.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * 邮件服务
 * 
 * @author dy 2020年8月24日
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private MyMailProperties myMailProperties;
	@Autowired
	private MailProperties mailProperties;

	@Override
	public void send(SimpleMailMessage message) {
		message.setFrom(mailProperties.getUsername());
		int sendCounter = 0;
		send: while (sendCounter < myMailProperties.getRetryCount()) {
			try {
				javaMailSender.send(message);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				sendCounter++;
				continue send;
			}
		}
		if (sendCounter >= myMailProperties.getRetryCount()) {
			throw new MailSendException("send email error...");
		}
	}

	/**
	 * 群发邮件 send
	 * 
	 * @param message
	 * @param receivers
	 * @author dy 2020年8月24日
	 */
	private void send(SimpleMailMessage message, String... receivers) {
		// 群发次数
		int sendCount = receivers.length / myMailProperties.getMaxCount();
		// 余数
		int remainder = receivers.length % myMailProperties.getMaxCount();
		if (remainder > 0) {// 如果余数大于0则发送次数+1
			sendCount = +1;
		}
		// 开始发送
		for (int i = 0; i < sendCount; i++) {
			int length = myMailProperties.getMaxCount();
			if (i == sendCount - 1 && remainder > 0) {// 最后一次
				length = remainder;
			}
			String[] rs = new String[length];
			for (int j = 0; j < length; j++) {
				rs[j] = receivers[i * myMailProperties.getMaxCount() + j];
			}
			message.setTo(rs);
			send(message);
		}
	}

	@Override
	public void send(String subject, String text, String[] picPaths, String[] picIds, String[] filePaths,
			String... receivers) {
		if (StringUtils.isBlank(subject)) {
			subject = myMailProperties.getSubject();
		}
		if (receivers == null || receivers.length == 0) {
			receivers = myMailProperties.getReceivers();
		}
		if (receivers == null || receivers.length == 0) {
			throw new MailSendException("Pleace to set receivers!!!");
		}
		try {
			if ((picPaths != null && picPaths.length > 0) || (filePaths != null && filePaths.length > 0)) {// 发送带图片或附件的邮件
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				// 发送人
				helper.setFrom(mailProperties.getUsername());
				// 邮件主题
				helper.setSubject(subject);
				// 邮件内容
				helper.setText(text, true);
				// 邮件的图片
				if (picPaths.length == picIds.length) {
					for (int i = 0; i < picIds.length; i++) {
						FileSystemResource file = new FileSystemResource(new File(picPaths[i]));
						helper.addInline(picIds[i], file);
					}
				}
				// 邮件附件
				for (int i = 0; i < filePaths.length; i++) {
					FileSystemResource file = new FileSystemResource(new File(filePaths[i]));
					// 获取附件的文件名
					String fileName = file.getFilename();
					helper.addAttachment(fileName, file);
				}

				// 群发次数
				int sendCount = receivers.length / myMailProperties.getMaxCount();
				// 余数
				int remainder = receivers.length % myMailProperties.getMaxCount();
				if (remainder > 0) {// 如果余数大于0则发送次数+1
					sendCount = +1;
				}
				// 开始发送
				for (int i = 0; i < sendCount; i++) {
					int length = myMailProperties.getMaxCount();
					if (i == sendCount - 1 && remainder > 0) {// 最后一次
						length = remainder;
					}
					String[] rs = new String[length];
					for (int j = 0; j < length; j++) {
						rs[j] = receivers[i * myMailProperties.getMaxCount() + j];
					}
					// 接收方
					helper.setTo(receivers);
					send(message);
				}
			} else {// 发送普通邮件
				SimpleMailMessage message = new SimpleMailMessage();
				message.setSubject(myMailProperties.getSubject());
				message.setText(text);
				send(message, receivers);
			}
		} catch (Exception e) {
			throw new MailSendException("send email error: ", e);
		}

	}

	@Override
	public void send(MimeMessage message) {
		int sendCounter = 0;
		send: while (sendCounter < myMailProperties.getRetryCount()) {
			try {
				javaMailSender.send(message);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				sendCounter++;
				continue send;
			}
		}
		if (sendCounter >= myMailProperties.getRetryCount()) {
			throw new MailSendException("send email error...");
		}
	}

	@Override
	public void sendHtml(String subject, String text, String... receivers) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			// 发送人
			helper.setFrom(mailProperties.getUsername());
			// 邮件主题
			if (StringUtils.isBlank(subject)) {
				helper.setSubject(myMailProperties.getSubject());
			} else {
				helper.setSubject(subject);
			}
			// 邮件内容
			helper.setText(text, true);
			// 接收方
			helper.setTo(receivers);
			send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
