package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.CardSizeDao;
import com.ajay.printers.model.CardSize;
import com.ajay.printers.service.CardSizeService;

@Service
@Transactional
public class CardSizeServiceImpl extends
		CRUDServiceImpl<Integer, CardSize, CardSizeDao> implements
		CardSizeService {
	@Autowired
	public CardSizeServiceImpl(CardSizeDao dao) {
		super(dao);
	}

}
