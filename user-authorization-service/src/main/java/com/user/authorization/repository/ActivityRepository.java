package com.user.authorization.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.authorization.entity.Activity;

 @Repository
public interface ActivityRepository extends CrudRepository<Activity, Date> {

}
