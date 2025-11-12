package com.lunaltas.dicegame.service;

import java.util.List;

import com.lunaltas.dicegame.domain.User;

public interface UserService {

	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User findById(Long id);
	
	List<User> findAll();
	
}