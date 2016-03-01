package com.ajay.printers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.printers.dao.SampleWeddingCardDao;
import com.ajay.printers.model.SampleWeddingCard;

@Service
@SuppressWarnings("unchecked")
public class SampleWeddingCardDaoImpl extends
		DAOImpl<Integer, SampleWeddingCard> implements SampleWeddingCardDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SampleWeddingCard> getAllBySize(int cardSizeId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				SampleWeddingCard.class);
		List<SampleWeddingCard> sampleWeddingCards = criteria.add(
				Restrictions.eq("cardSize.id", cardSizeId)).list();
		return sampleWeddingCards;
	}

}
