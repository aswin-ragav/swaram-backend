package com.user.authorization.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>,CrudRepository<Contact, Long>{

}
