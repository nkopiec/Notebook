package pl.whitelines.services;

import pl.whitelines.entities.Messages;

public interface MessagesService {
	public Messages findMessage(String email);
}
