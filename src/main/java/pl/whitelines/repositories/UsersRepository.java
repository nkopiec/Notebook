package pl.whitelines.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.whitelines.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
	public User findByLoginAndPassword(String login, String password);
}
