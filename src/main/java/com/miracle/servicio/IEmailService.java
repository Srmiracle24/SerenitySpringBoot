package com.miracle.servicio;

import com.miracle.servicio.dto.EmailDTO;

import jakarta.mail.MessagingException;

public interface IEmailService {

	public void sendMail(EmailDTO email) throws MessagingException;

}
