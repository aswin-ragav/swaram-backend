package com.user.authorization.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.authorization.Interface.CRUD;
import com.user.authorization.entity.Address;
import com.user.authorization.repository.AddressRepository;

@Service
public class AddressService implements CRUD<Address> {

	private static final  Logger LOGGER = LoggerFactory
	                                    .getLogger(AddressService.class);

	@Autowired
	private AddressRepository repository;

	private Address operationStatus(Address address, String message) {

		address.setEntityMessage(message);
		return address;
	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public Address create(Address address) {

		try {

			address = repository.save(address);

			return operationStatus(address, "Saved");

		} catch (Exception e) {

			return operationStatus(address, "Unable to Save");
		}
	}


	@Override
	public Address read(long id) {

		Optional<Address> address = null;
		Address           message = new Address();

		try {

			address = repository.findById(id);

			message.setEntityMessage("Id not found");

			return address.isPresent() ? address.get() : message;
		} catch (Exception e) {

			return operationStatus(message, "Error");
		}

	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public Address update(Address address) {

		try {

			Optional<Address> findById = repository.findById(address.getId());
			Address           update   = findById.isPresent()
			                                    ? findById.get()
			                                    : null;

			if (update != null) {

				if (address.getZipcode() != null) {

					update.setZipcode(address.getZipcode());
				}

				if (address.getAddress1() != null) {

					update.setAddress1(address.getAddress1());
				}

				if (address.getAddress2() != null) {

					update.setAddress2(address.getAddress2());
				}

				if (address.getCity() != null) {

					update.setCity(address.getCity());
				}

				if (address.getNationality() != null) {

					update.setNationality(address.getNationality());
				}

				if (address.getState() != null) {

					update.setState(address.getState());
				}

				return operationStatus(repository.save(update), "Updated");
			}

			return operationStatus(new Address(), "No record found");
		} catch (Exception e) {

			return operationStatus(address, "Error updating entity");
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
