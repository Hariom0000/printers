package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;

import com.ajay.printers.dao.UserCastDao;
import com.ajay.printers.model.UserCast;

@Service
public class UserCastDaoImpl extends DAOImpl<Integer, UserCast> implements
		UserCastDao {

}
