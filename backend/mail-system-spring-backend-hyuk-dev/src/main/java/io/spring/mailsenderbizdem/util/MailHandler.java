package io.spring.mailsenderbizdem.util;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {
	
	private JavaMailSender sender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
<<<<<<< HEAD
	public MailHandler(JavaMailSender jSender) throws MessagingException, javax.mail.MessagingException {
=======
	public MailHandler(JavaMailSender jSender) throws MessagingException{
>>>>>>> testbranch
		this.sender = jSender;
		message = jSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		
	}
	
	public void setFrom(String fromAddress) throws javax.mail.MessagingException {
		messageHelper.setFrom(fromAddress);
		
	}
	
	public void setTo(String email) throws javax.mail.MessagingException {
		messageHelper.setTo(email);
	}
	
<<<<<<< HEAD
	public void setCcs(String[] ccs) throws javax.mail.MessagingException {
		messageHelper.setCc(ccs);
	}
=======
	// public void setCcs(String[] ccs) throws javax.mail.MessagingException {
	// 	messageHelper.setCc(ccs);
	// }
>>>>>>> testbranch

	public void setSubject(String subject) throws javax.mail.MessagingException {
		messageHelper.setSubject(subject);
	}
	
	public void setText(String text, boolean userHtml) throws javax.mail.MessagingException {
		messageHelper.setText(text, userHtml);
	}
	
	public void setAttach(String displayFileName, String pathToAttachment) throws IOException, javax.mail.MessagingException {
		File file = new ClassPathResource(pathToAttachment).getFile();
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addAttachment(displayFileName, fsr);
		
	}
	
	public void setInline(String contentId, String pathToInline) throws IOException, javax.mail.MessagingException {
		File file = new ClassPathResource(pathToInline).getFile();
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addInline(contentId, fsr);
		
	}
	
<<<<<<< HEAD
	
	
	public void send() {
		try {
			sender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
=======
	public void send() throws MessagingException{
			sender.send(message);
>>>>>>> testbranch
	}

}
