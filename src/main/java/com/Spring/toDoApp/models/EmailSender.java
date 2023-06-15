package com.Spring.toDoApp.models;


import java.io.StringWriter;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	public void sendEmailUsingVelocityTemplate(Vuser us) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(jakarta.mail.internet.MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(us.getToAddress());
				message.setFrom(us.getFromAddress());
				message.setSubject(us.getSubject());
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("us", us);
				StringWriter stringWriter = new StringWriter();
				velocityEngine.mergeTemplate("templates/vtemplates/email-template.vm", "UTF-8", velocityContext, stringWriter);
				message.setText(stringWriter.toString(), true);
				
			}
		};

		try {
			mailSender.send(preparator);

			System.out.println("Email sending complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
