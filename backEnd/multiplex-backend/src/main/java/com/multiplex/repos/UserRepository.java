package com.multiplex.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	Optional<User> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
