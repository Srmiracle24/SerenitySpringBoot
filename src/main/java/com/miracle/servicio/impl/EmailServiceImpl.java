package com.miracle.servicio.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.miracle.servicio.IEmailService;
import com.miracle.servicio.dto.EmailDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

	private final JavaMailSender javaMailSender;
	private final TemplateEngine templeteEngine;

	public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templeteEngine) {

		this.javaMailSender = javaMailSender;
		this.templeteEngine = templeteEngine;
	}

	@Override
	public void sendMail(EmailDTO email) throws MessagingException {

		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setTo(email.getDestinatario());
			// helper.setSubject(email.getAsunto());
			helper.setSubject("Bienvenido a Serenity");
			// helper.setText(email.getMensaje());

			Context context = new Context();
			context.setVariable("mensaje", email.getMensaje());
			String contentHTML = templeteEngine.process("email", context);
			helper.setText(contentHTML, true);
			javaMailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException("Error al enviar" + " el correo" + e.getMessage(), e);
		}

	}
}
