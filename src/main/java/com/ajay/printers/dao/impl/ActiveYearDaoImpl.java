package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;

import com.ajay.printers.dao.ActiveYearDao;
import com.ajay.printers.model.ActiveYear;

@Service
public class ActiveYearDaoImpl extends DAOImpl<Integer, ActiveYear> implements
		ActiveYearDao {

}
