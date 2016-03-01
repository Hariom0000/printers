package com.ajay.printers.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.beans.SampleWeddingCardBean;
import com.ajay.printers.dao.SampleWeddingCardDao;
import com.ajay.printers.model.SampleWeddingCard;
import com.ajay.printers.service.SampleWeddingCardService;
import com.ajay.printers.util.SampleWeddingCardConverter;

@Service
@Transactional
public class SampleWeddingCardServiceImpl extends
		CRUDServiceImpl<Integer, SampleWeddingCard, SampleWeddingCardDao>
		implements SampleWeddingCardService {

	@Autowired
	public SampleWeddingCardServiceImpl(SampleWeddingCardDao dao) {
		super(dao);
	}

	@Override
	public List<SampleWeddingCardBean> getAllSampleWeddingCard() {
		List<SampleWeddingCardBean> sampleWeddingCardBeans = new ArrayList<SampleWeddingCardBean>();
		for (SampleWeddingCard sampleWeddingCard : dao
				.findAll(SampleWeddingCard.class))
			sampleWeddingCardBeans.add(SampleWeddingCardConverter.getInstance()
					.entityToBean(sampleWeddingCard));
		return sampleWeddingCardBeans;
	}

	@Override
	public List<SampleWeddingCardBean> getAllBySize(int cardSizeId) {
		List<SampleWeddingCardBean> sampleWeddingCardBeans = new ArrayList<SampleWeddingCardBean>();
		for (SampleWeddingCard sampleWeddingCard : dao
				.getAllBySize(cardSizeId))
			sampleWeddingCardBeans.add(SampleWeddingCardConverter.getInstance()
					.entityToBean(sampleWeddingCard));
		return sampleWeddingCardBeans;
	}

}
