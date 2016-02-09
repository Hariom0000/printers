package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.RoleDao;
import com.ajay.printers.model.Role;

@Service
@Transactional
public class RoleDaoImpl extends DAOImpl<Integer, Role> implements RoleDao {

	

}
