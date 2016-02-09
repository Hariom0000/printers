package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.CardTypeDao;
import com.ajay.printers.model.CardType;
import com.ajay.printers.service.CardTypeService;

@Service
@Transactional
public class CardTypeServiceImpl extends
		CRUDServiceImpl<Integer, CardType, CardTypeDao> implements
		CardTypeService {
	@Autowired
	public CardTypeServiceImpl(CardTypeDao dao) {
		super(dao);
	}

}
