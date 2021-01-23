package com.user.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, CrudRepository<Contact, Long> {

	@Query(value = "SELECT * FROM Contact AS c WHERE c.email=?1", nativeQuery = true)
	Contact verifyByEmail(String email);

}
