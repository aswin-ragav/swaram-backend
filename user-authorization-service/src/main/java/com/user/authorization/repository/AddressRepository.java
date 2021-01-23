package com.user.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
