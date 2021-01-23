package com.user.authorization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long> {

	@Query(value = "SELECT username FROM user_registration WHERE username=?1",
	       nativeQuery = true)
	Optional<String> verifyUserName(String userName);

	@Query(value = "SELECT email_address FROM user_registration WHERE email_address=?1",
	       nativeQuery = true)
	Optional<String> verifyEmail(String email);

	@Modifying
	@Query(value = "UPDATE user_registration SET status='ACTIVE' WHERE status='INACTIVE' AND unique_id=?1",
	       nativeQuery = true)
	Integer findUniqueID(String uniqueId);

	@Query(value = "SELECT * FROM user_registration WHERE unique_id=?1",
	       nativeQuery = true)
	Optional<Register> findUserById(String uniqueId);

}
