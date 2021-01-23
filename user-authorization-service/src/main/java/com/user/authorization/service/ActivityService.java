package com.user.authorization.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.authorization.entity.Activity;
import com.user.authorization.entity.Authorization;
import com.user.authorization.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;

	@Autowired
	private ObjectMapper objMapper;

	@KafkaListener(topics = "activity_Topic", groupId = "group-id")
	private void consumeAuthorizationTopic(String message) {

		System.out.println(message);
		Activity activity = new Activity();

		try {

			Authorization authorization = objMapper.readValue(message,
			                                    Authorization.class);

			activity.setId(authorization.getId());
			activity.setActivityType(authorization.isLogged());
			activity.setDate(new Date());

			saveOrUpdate(activity);

		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

	}


	private void saveOrUpdate(Activity activity) {

		repository.save(activity);

	}

}
