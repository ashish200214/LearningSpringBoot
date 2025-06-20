package com.security.LearningSpringSecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.LearningSpringSecurity.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
	Optional<UserModel>findByUsername(String username);
}
