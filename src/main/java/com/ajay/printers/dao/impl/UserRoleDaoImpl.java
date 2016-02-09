package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;

import com.ajay.printers.dao.UserRoleDao;
import com.ajay.printers.model.UserRole;
import com.ajay.printers.model.UserRoleId;

@Service
public class UserRoleDaoImpl extends DAOImpl<UserRoleId, UserRole> implements
		UserRoleDao {

}
