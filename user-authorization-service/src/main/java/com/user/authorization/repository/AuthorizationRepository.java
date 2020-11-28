package com.user.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.User;

@Repository
public interface AuthorizationRepository extends JpaRepository<User, Long> {

}
