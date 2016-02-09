package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.UserDao;
import com.ajay.printers.model.User;
import com.ajay.printers.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends CRUDServiceImpl<Integer, User, UserDao>
		implements UserService {

	@Autowired
	public UserServiceImpl(UserDao dao) {
		super(dao);
	}

	@Transactional
	public User getUserByUserName(String userName) {
		return dao.getUserByUsername(userName);

	}

}
