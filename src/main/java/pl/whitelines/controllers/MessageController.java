package pl.whitelines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.EmailData;
import pl.whitelines.entities.Messages;
import pl.whitelines.services.MessagesService;

@RestController
public class MessageController {
	@Autowired
	private MessagesService messagesService;
	
	@PostMapping("/messages")
	public ResponseEntity<Void> messages(@RequestBody EmailData emailData) {
		Messages messages = messagesService.findMessage(emailData.getEmail());
		if (messages == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
