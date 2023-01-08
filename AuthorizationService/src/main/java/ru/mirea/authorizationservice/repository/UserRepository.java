package ru.mirea.authorizationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.mirea.authorizationservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	User findByUsername(String userName);

	User findById(long userId);

}
