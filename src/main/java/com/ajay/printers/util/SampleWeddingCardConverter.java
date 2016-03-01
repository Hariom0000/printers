package com.ajay.printers.util;

import com.ajay.printers.beans.SampleWeddingCardBean;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.model.CardSize;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.SampleWeddingCard;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.model.WeddingCardFrontImage;

public class SampleWeddingCardConverter {
	private static final SampleWeddingCardConverter sampleWeddingCardConverter = new SampleWeddingCardConverter();

	public static final SampleWeddingCardConverter getInstance() {
		return sampleWeddingCardConverter;
	}

	public SampleWeddingCard beanToEntity(
			SampleWeddingCardBean sampleWeddingCardBean) {
		SampleWeddingCard sampleWeddingCard = new SampleWeddingCard();

		ActiveYear activeYear = new ActiveYear();
		activeYear.setId(sampleWeddingCardBean.getActiveYearId());
		sampleWeddingCard.setActiveYear(activeYear);

		UserCast userCast = new UserCast();
		userCast.setId(sampleWeddingCardBean.getUserCastId());
		sampleWeddingCard.setUserCast(userCast);

		CardSize cardSize = new CardSize();
		cardSize.setId(sampleWeddingCardBean.getCardSizeId());
		sampleWeddingCard.setCardSize(cardSize);
		sampleWeddingCard.setCardNumber(sampleWeddingCardBean.getCardNumber());

		CardType cardType = new CardType();
		cardType.setId(sampleWeddingCardBean.getCardTypeId());
		sampleWeddingCard.setCardType(cardType);

		sampleWeddingCard.setFrontImg(sampleWeddingCardBean.getFrontImg());
		sampleWeddingCard.setId(sampleWeddingCardBean.getId());
		sampleWeddingCard.setLastImg(sampleWeddingCardBean.getLastImg());
		sampleWeddingCard.setMainImg(sampleWeddingCardBean.getMainImg());
		sampleWeddingCard.setMiddleImg(sampleWeddingCardBean.getMiddleImg());

		WeddingCardFrontImage weddingCardFrontImage = new WeddingCardFrontImage();
		weddingCardFrontImage.setId(sampleWeddingCardBean
				.getWeddingCardFrontImageId());
		sampleWeddingCard.setWeddingCardFrontImage(weddingCardFrontImage);

		return sampleWeddingCard;
	}

	public SampleWeddingCardBean entityToBean(
			SampleWeddingCard sampleWeddingCard) {
		SampleWeddingCardBean sampleWeddingCardBean = new SampleWeddingCardBean();
		sampleWeddingCardBean.setActiveYear(sampleWeddingCard.getActiveYear()
				.getYear());
		sampleWeddingCardBean.setActiveYearId(sampleWeddingCard.getActiveYear()
				.getId());
		sampleWeddingCardBean.setCardNumber(sampleWeddingCard.getCardNumber());
		sampleWeddingCardBean.setCardType(sampleWeddingCard.getCardType()
				.getType());
		sampleWeddingCardBean.setCardTypeId(sampleWeddingCard.getCardType()
				.getId());
		sampleWeddingCardBean.setFrontImg(sampleWeddingCard.getFrontImg());
		sampleWeddingCardBean.setId(sampleWeddingCard.getId());
		sampleWeddingCardBean.setLastImg(sampleWeddingCard.getLastImg());
		sampleWeddingCardBean.setMainImg(sampleWeddingCard.getMainImg());
		sampleWeddingCardBean.setMiddleImg(sampleWeddingCard.getMiddleImg());
		sampleWeddingCardBean.setUserCast(sampleWeddingCard.getUserCast()
				.getCast());
		sampleWeddingCardBean.setUserCastId(sampleWeddingCard.getUserCast()
				.getId());
		sampleWeddingCardBean.setWeddingCardFrontImage(sampleWeddingCard
				.getWeddingCardFrontImage().getFrontImageName());
		sampleWeddingCardBean.setWeddingCardFrontImageId(sampleWeddingCard
				.getWeddingCardFrontImage().getId());
		sampleWeddingCardBean.setCardSize(sampleWeddingCard.getCardSize().getSize());
		sampleWeddingCardBean.setCardSizeId(sampleWeddingCard.getCardSize().getId());
		return sampleWeddingCardBean;
	}
}
