package pl.whitelines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.whitelines.entities.User;
import pl.whitelines.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public User findUser(String login, String password) {
		return usersRepository.findByLoginAndPassword(login, password);
	}
}
