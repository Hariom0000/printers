package com.ajay.printers.service;

import java.util.List;

import com.ajay.printers.beans.SampleWeddingCardBean;
import com.ajay.printers.model.SampleWeddingCard;

public interface SampleWeddingCardService extends
		CRUDService<Integer, SampleWeddingCard> {
	List<SampleWeddingCardBean> getAllSampleWeddingCard();

	List<SampleWeddingCardBean> getAllBySize(int cardSizeId);

}
