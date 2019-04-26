package pl.whitelines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.whitelines.entities.Messages;
import pl.whitelines.entities.User;
import pl.whitelines.repositories.MessageRepository;

@Service
public class MessagesServiceImpl implements MessagesService{
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Messages findMessage(String email) {
		return messageRepository.findMessage(email, email);
	}

}
