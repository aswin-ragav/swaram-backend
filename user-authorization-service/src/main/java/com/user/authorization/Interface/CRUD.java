package com.user.authorization.Interface;

import org.springframework.stereotype.Service;

@Service
public interface CRUD<T> {

	T create(T t);

	T read(long id);

	T update(T t);

	boolean delete(long id);

}
