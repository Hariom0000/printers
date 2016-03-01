package com.ajay.printers.dao;

import java.util.List;

import com.ajay.printers.model.SampleWeddingCard;

public interface SampleWeddingCardDao extends DAO<Integer, SampleWeddingCard> {
	
	public List<SampleWeddingCard> getAllBySize(int cardSizeId);

}
