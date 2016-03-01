package com.ajay.printers.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.dao.ActiveYearDao;
import com.ajay.printers.dao.CardSizeDao;
import com.ajay.printers.dao.CardTypeDao;
import com.ajay.printers.dao.UserCastDao;
import com.ajay.printers.dao.WeddingCardDao;
import com.ajay.printers.dao.WeddingCardFrontImageDao;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.model.CardSize;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.model.WeddingCard;
import com.ajay.printers.model.WeddingCardFrontImage;
import com.ajay.printers.service.WeddingCardService;
import com.ajay.printers.util.WeddingCardConverter;

@Service
@Transactional
public class WeddingCardServiceImpl extends
		CRUDServiceImpl<Integer, WeddingCard, WeddingCardDao> implements
		WeddingCardService {
	@Autowired
	public WeddingCardServiceImpl(WeddingCardDao dao) {
		super(dao);
	}

	@Autowired
	private UserCastDao userCastDao;
	@Autowired
	private ActiveYearDao activeYearDao;
	@Autowired
	private WeddingCardFrontImageDao weddingCardFrontImageDao;
	@Autowired
	private CardTypeDao cardTypeDao;
	@Autowired
	private CardSizeDao cardSizeDao;

	@Override
	public List<WeddingCardBean> getAllWeddingCard() {
		List<WeddingCardBean> weddingCardBeans = new ArrayList<WeddingCardBean>();
		List<WeddingCard> weddingCards = dao.findAll(WeddingCard.class);
		for (WeddingCard weddingCard : weddingCards) {
			weddingCardBeans.add(WeddingCardConverter.getInstance()
					.entityToBean(weddingCard));
		}
		return weddingCardBeans;
	}

	@Override
	public Map<String, Object> getWeddingCardBaseData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usercast", userCastDao.findAll(UserCast.class));
		map.put("activeyear", activeYearDao.findAll(ActiveYear.class));
		map.put("weddingcardfrontimage",
				weddingCardFrontImageDao.findAll(WeddingCardFrontImage.class));
		map.put("cardtype", cardTypeDao.findAll(CardType.class));
		map.put("cardsize", cardSizeDao.findAll(CardSize.class));
		return map;
	}

	@Override
	public WeddingCardBean getById(int weddingCardId) {
		return WeddingCardConverter.getInstance().entityToBean(
				dao.get(weddingCardId));
	}

}
