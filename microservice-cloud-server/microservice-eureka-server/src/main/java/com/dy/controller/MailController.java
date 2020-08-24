package com.dy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.mail.MailService;

@RestController
@RequestMapping("mail")
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("text")
	public String name() {
//		mailService.send("纯文本测试");
		String[] picPaths = { "C:\\Users\\Administrator\\Desktop\\cloudconfig\\timg.jpg",
				"C:\\Users\\Administrator\\Desktop\\cloudconfig\\u=2873034231,1191081182&fm=26&gp=0.jpg" };
		String[] picIds = { "PIC001", "PIC002" };
		String text = "<html><body>我的这封邮件可是很厉害的,因为它可以显示图片呦!!!\n" + "<img src=\'cid:" + picIds[0]
				+ "\'></img></body></html>" + "<img src=\'cid:" + picIds[1] + "\'></img></body></html>";
		String[] filePaths = { "C:\\Users\\Administrator\\Desktop\\都江堰质量评价体系.zip",
				"C:\\Users\\Administrator\\Desktop\\邓勇个人简历.docx" };
		String[] receivers = null;
		mailService.send("测试主题", text, picPaths, picIds, filePaths, receivers);
		return "发送成功";
	}

}
