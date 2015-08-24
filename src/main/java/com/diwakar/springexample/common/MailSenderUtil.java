/**
 * 
 */
package com.diwakar.springexample.common;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: MainSender.java
 */
public class MailSenderUtil {


	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String subject, String msg) {

		System.out.println("Sending mail now.....inside sendMail()");
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		try
		{
		mailSender.send(message);
		}
		catch(Exception e)
		{
			System.out.println("Exception in sendMail()" + e);
		}
		System.out.println("mail sent!!");
	}
}


