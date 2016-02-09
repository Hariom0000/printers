package com.ajay.printers.dao;

import com.ajay.printers.model.User;

public interface UserDao extends DAO<Integer, User> {
	public User getUserByUsername(String username);

}
