package pl.whitelines.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.whitelines.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
}