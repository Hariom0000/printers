package com.ajay.printers.service;

import com.ajay.printers.model.User;

public interface UserService extends CRUDService<Integer, User> {
	public User getUserByUserName(String userName);
}
