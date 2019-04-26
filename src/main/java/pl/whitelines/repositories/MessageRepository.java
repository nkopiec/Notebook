package pl.whitelines.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.whitelines.entities.Messages;

public interface MessageRepository extends CrudRepository<Messages, String> {
		public Messages findMessage(String email, String message);
}

