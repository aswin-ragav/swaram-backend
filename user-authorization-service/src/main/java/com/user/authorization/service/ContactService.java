package com.user.authorization.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.authorization.Interface.CRUD;
import com.user.authorization.entity.Contact;
import com.user.authorization.repository.ContactRepository;

@Service
public class ContactService implements CRUD<Contact> {

	private static final Logger LOGGER = LoggerFactory
	                                    .getLogger(ContactService.class);

	@Autowired
	private ContactRepository repository;

	private Contact operationStatus(Contact contact, String message) {

		contact.setEntityMessage(message);
		return contact;
	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public Contact create(Contact contact) {

		try {

			return operationStatus(repository.save(contact), "Saved");

		} catch (Exception e) {

			return operationStatus(contact, "Unable to Save");
		}

	}


	@Override
	public Contact read(long id) {

		Optional<Contact> contact = null;
		Contact           message = new Contact();

		try {

			contact = repository.findById(id);

			message.setEntityMessage("Id not found");

			return contact.isPresent() ? contact.get() : message;

		} catch (Exception e) {

			return operationStatus(message, "Error");
		}

	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public Contact update(Contact contact) {

		try {

			Optional<Contact> findById = repository.findById(contact.getId());
			Contact           update   = findById.isPresent()
			                                    ? findById.get()
			                                    : null;

			if (update != null) {

				if (contact.getAlternateEmail() != null) {

					update.setAlternateEmail(contact.getAlternateEmail());
				}

				if (contact.getAlternatePhoneNumber() != null) {

					update.setAlternatePhoneNumber(contact
					                                    .getAlternatePhoneNumber());
				}

				if (contact.getDob() != null) {

					update.setDob(contact.getDob());
				}

				if (contact.getPhoneNumber() != null) {

					update.setPhoneNumber(contact.getPhoneNumber());
				}

				return operationStatus(repository.save(update), "Updated");
			}

			return operationStatus(new Contact(), "Error updating entity");
		} catch (Exception e) {

			return operationStatus(contact, "Error updating entity");
		}

	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean delete(long id) {

		try {

			repository.deleteById(id);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

}
