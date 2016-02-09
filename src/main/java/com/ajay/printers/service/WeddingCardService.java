package com.ajay.printers.service;

import java.util.List;
import java.util.Map;

import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.model.WeddingCard;

public interface WeddingCardService extends CRUDService<Integer, WeddingCard> {
	
	public List<WeddingCardBean> getAllWeddingCard();
	
	public Map<String, Object> getWeddingCardBaseData();

}
