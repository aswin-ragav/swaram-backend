package com.user.authorization.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.authorization.entity.Register;
import com.user.authorization.Interface.AuthorizationCommon;
import com.user.authorization.entity.Authorization;
import com.user.authorization.repository.AuthorizationRepository;

@Service
public class AuthororizationService implements AuthorizationCommon {

	private static final Logger LOGGER = LoggerFactory
	                                    .getLogger(AuthororizationService.class);

	@Autowired
	private AuthorizationRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	private ObjectMapper objMapper;

	@Override
	public Authorization logIn(String uNameOrEmail, String password) {

		Authorization authorization = null;

		/*
		 * Log user by UserName
		 */
		Optional<Authorization> userNameAvailable = isUserNameAvailable(
		                                    uNameOrEmail);

		if (checkUserAvailability(password, userNameAvailable)) {

			authorization = updateUserLoggingStatus(userNameAvailable);

			sentActivity(authorization);

			return authorization;
		}

		/*
		 * Log user by Email
		 */
		Optional<Authorization> emailIdAvailable = isEmailIdAvailable(
		                                    uNameOrEmail);

		if (checkUserAvailability(password, emailIdAvailable)) {

			authorization = updateUserLoggingStatus(emailIdAvailable);

			sentActivity(authorization);

			return authorization;
		}

		authorization = new Authorization();
		authorization.setEntityMessage("UserName or EmailId not available");

		return authorization;
	}


	private void sentActivity(Authorization authorization) {

		kafkaTemplate.send("activityTopic", authorization);
	}


	@Override
	public boolean signOff(String uNameOrEmail) {

		/*
		 * Log user by Email
		 */
		Optional<Authorization> emailIdAvailable = isEmailIdAvailable(
		                                    uNameOrEmail);

		if (emailIdAvailable.isPresent()) {

			return updateSignOffActivity(emailIdAvailable);
		}
		/*
		 * Log user by UserName
		 */
		Optional<Authorization> userNameAvailable = isUserNameAvailable(
		                                    uNameOrEmail);

		if (userNameAvailable.isPresent()) {

			return updateSignOffActivity(userNameAvailable);
		}

		return false;
	}


	private boolean updateSignOffActivity(
	                                    Optional<Authorization> userNameAvailable) {

		userNameAvailable.get().setLogged(false);

		Authorization save = repository.save(userNameAvailable.get());

		sentActivity(save);

		return save != null ? true : false;
	}


	private Authorization updateUserLoggingStatus(
	                                    Optional<Authorization> userNameAvailable) {

		userNameAvailable.get().setLogged(true);

		return repository.save(userNameAvailable.get());
	}


	private boolean checkUserAvailability(String password,
	                                    Optional<Authorization> emailIdAvailable) {

		return emailIdAvailable.isPresent() && decodePwd(password,
		                                    emailIdAvailable.get().getPassword());
	}


	private Optional<Authorization> isUserNameAvailable(String userName) {

		return repository.verifyUserName(userName.trim());
	}


	private Optional<Authorization> isEmailIdAvailable(String emailId) {

		return repository.verifyEmail(emailId.trim());
	}


	private Authorization saveOrUpdate(Authorization authorization) {

		return repository.save(authorization);
	}


	@KafkaListener(topics = "authorization_Topic", groupId = "group-id")
	private void consumeAuthorizationTopic(String message) {

		Authorization authorization = new Authorization();

		try {

			Register register = objMapper.readValue(message, Register.class);

			authorization.setId(register.getId());
			authorization.setMailId(register.getMailId());
			authorization.setPassword(register.getPassword());
			authorization.setUserName(register.getUserName());
			authorization.setLogged(false);
			authorization.setDate(new Date());
			
			saveOrUpdate(authorization);

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

	}


	/*
	 * @params = String rawPassword, String encodedPassword
	 *
	 * password[0] = rawPassword
	 * password[1] = encodedPassword
	 */
	private boolean decodePwd(String... password) {

		return passwordEncoder.matches(password[0], password[1]);
	}

}
