package com.ajay.printers.dao.impl;

import org.springframework.stereotype.Service;

import com.ajay.printers.dao.CardTypeDao;
import com.ajay.printers.model.CardType;

@Service
public class CardTypeDaoImpl extends DAOImpl<Integer, CardType> implements
		CardTypeDao {

}
