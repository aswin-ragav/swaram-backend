package com.user.authorization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Authorization;

@Repository
public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {

	@Query(value = "SELECT * FROM user_authorization WHERE username=?1",
	       nativeQuery = true)
	Optional<Authorization> verifyUserName(String userName);

	@Query(value = "SELECT * FROM user_authorization WHERE email_address=?1",
	       nativeQuery = true)
	Optional<Authorization> verifyEmail(String email);

}
