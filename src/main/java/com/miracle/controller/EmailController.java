package com.miracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.servicio.IEmailService;
import com.miracle.servicio.dto.EmailDTO;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/enviar_email")
public class EmailController {

	@Autowired
	IEmailService emailService;

	@PostMapping
	private ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {

		emailService.sendMail(email);
		return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);

	}

}
