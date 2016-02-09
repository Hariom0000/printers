package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.UserCastDao;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.service.UserCastService;

@Service
@Transactional
public class UserCastServiceImpl extends
		CRUDServiceImpl<Integer, UserCast, UserCastDao> implements
		UserCastService {
	@Autowired
	public UserCastServiceImpl(UserCastDao dao) {
		super(dao);
	}

}
