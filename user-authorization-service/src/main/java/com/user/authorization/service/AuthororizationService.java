package com.user.authorization.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.user.authorization.entity.Address;
import com.user.authorization.entity.Contact;
import com.user.authorization.entity.User;
import com.user.authorization.repository.AddressRepository;
import com.user.authorization.repository.AuthorizationRepository;
import com.user.authorization.repository.AuthorizationStorageService;
import com.user.authorization.repository.ContactRepository;

@Service
public class AuthororizationService implements AuthorizationStorageService {

	@Autowired
	private AuthorizationRepository repository;
	@Autowired
	private AddressRepository addrRepository;
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public User addNewUser(User addUser) {

		addUser.getAddress().forEach(x -> addrRepository.save(x));
		addUser.getContact().forEach(x -> contactRepository.save(x));
		User save = repository.save(addUser);

		return save;
	}

	@Override
	public boolean deleteUser(long id) {
		User one = repository.getOne(id);
		repository.delete(one);
		return true;
	}

	@Override
	public User updateUserDetails(User update) {
		User one = repository.getOne(update.getId());
		final Example<User> example = Example.of(update, ExampleMatcher.matchingAny().withIgnoreNullValues());
		repository.exists(example);
		return null;
	}

}
