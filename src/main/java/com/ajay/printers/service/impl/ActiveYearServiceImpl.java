package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.ActiveYearDao;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.service.ActiveYearService;

@Service
@Transactional
public class ActiveYearServiceImpl extends
		CRUDServiceImpl<Integer, ActiveYear, ActiveYearDao> implements
		ActiveYearService {

	@Autowired
	public ActiveYearServiceImpl(ActiveYearDao dao) {
		super(dao);
	}

}
