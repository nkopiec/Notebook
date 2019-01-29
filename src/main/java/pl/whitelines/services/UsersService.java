package pl.whitelines.services;

import pl.whitelines.entities.User;

public interface UsersService {
	public User findUser(String login, String password);
}
