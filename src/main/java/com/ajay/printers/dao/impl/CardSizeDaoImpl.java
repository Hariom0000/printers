package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;

import com.ajay.printers.dao.CardSizeDao;
import com.ajay.printers.model.CardSize;

@Service
public class CardSizeDaoImpl extends DAOImpl<Integer, CardSize> implements
		CardSizeDao {

}
