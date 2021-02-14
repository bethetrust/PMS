package io.spring.mailsenderbizdem.service;

import java.io.File;
<<<<<<< HEAD
import java.util.List;

=======
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

>>>>>>> testbranch
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.mail.MailException;
>>>>>>> testbranch
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.MailDto;
import io.spring.mailsenderbizdem.util.MailHandler;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailSendService {

	@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "hyuksamah@gmail.com";

<<<<<<< HEAD
	public void mailSend(MailDto mailDto) {
=======
	public void mailSend(MailDto mailDto) throws MessagingException, IOException {
>>>>>>> testbranch
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(mailDto.getAddress());
//		message.setFrom(MailService.FROM_ADDRESS);
//		message.setSubject(mailDto.getTitle());
//		message.setText(mailDto.getMessage());
//		
//		mailSender.send(message);

<<<<<<< HEAD
		try {
			
=======
>>>>>>> testbranch
			// String message = mailDto.getMessage();
			MailHandler mailHandler = new MailHandler(mailSender);

			
			// 받는 사람
			mailHandler.setTo(mailDto.getAddress());
			// 참조
<<<<<<< HEAD
			mailHandler.setCcs(mailDto.getCcs());
=======
			// mailHandler.setCcs(mailDto.getCcs());
>>>>>>> testbranch
			// 보내는 사람
			mailHandler.setFrom(MailSendService.FROM_ADDRESS);
			// 제목
			mailHandler.setSubject(mailDto.getTitle());
			
			

			// jsoup test
			// File input = new ClassPathResource("static/mail34.html").getFile();
			File htmlTemplate = mailDto.getHtmlTemplate();
<<<<<<< HEAD
			
=======
			System.out.println("-----------------------------");
            System.out.println(htmlTemplate.length());
>>>>>>> testbranch
		
			Document doc = Jsoup.parse(htmlTemplate, "UTF-8", "http://test.com");
			Element td = doc.body().getElementById("mailResult");
			if(td != null) {
				System.out.println("--------------------------------------------------------------");
<<<<<<< HEAD
				td.append("<a href=\"http://localhost3000/mailresponse/"+mailDto.getSendRecNo()+"\">참여</a>");
=======
				td.append("<a href=\"http://localhost:3000/mailresponse/"+mailDto.getSendRecNo()+"\">참여</a>");
>>>>>>> testbranch
			}
			System.out.println("succ");
			System.out.println("-------------------------------------");
			String body = doc.html();

			// HTML Layout
			String htmlContent = body;
//			String htmlContent = "test";
			mailHandler.setText(htmlContent, true);
			// 첨부 파일
			// mailHandler.setAttach("newTest.txt", "static/originTest.txt");
			// // 이미지 삽입
			// mailHandler.setInline("sample-img", "static/sample1.jpg");

			mailHandler.send();

<<<<<<< HEAD
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
=======
	}

}
>>>>>>> testbranch
