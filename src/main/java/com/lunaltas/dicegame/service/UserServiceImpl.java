package com.lunaltas.dicegame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

  import com.lunaltas.dicegame.dao.UserDao;
import com.lunaltas.dicegame.domain.User;

@Service @Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public void save(User user) {
		dao.save(user);		
	}

	@Override
	public void update(User user) {
		dao.update(user);		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public User findById(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<User> findAll() {
		
		return dao.findAll();
	}


}
