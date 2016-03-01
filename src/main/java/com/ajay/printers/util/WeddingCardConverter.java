package com.ajay.printers.util;

import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.model.CardSize;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.model.WeddingCard;
import com.ajay.printers.model.WeddingCardFrontImage;

public class WeddingCardConverter {
	private static final WeddingCardConverter weddingCardEntityToBean = new WeddingCardConverter();

	public static final WeddingCardConverter getInstance() {
		return weddingCardEntityToBean;
	}

	public WeddingCard beanToEntity(WeddingCardBean weddingCardBean) {
		WeddingCard weddingCard = new WeddingCard();

		ActiveYear activeYear = new ActiveYear();
		activeYear.setId(weddingCardBean.getActiveYearId());
		weddingCard.setActiveYear(activeYear);

		UserCast userCast = new UserCast();
		userCast.setId(weddingCardBean.getUserCastId());
		weddingCard.setUserCast(userCast);

		weddingCard.setCardNumber(weddingCardBean.getCardNumber());

		CardType cardType = new CardType();
		cardType.setId(weddingCardBean.getCardTypeId());
		weddingCard.setCardType(cardType);

		CardSize cardSize = new CardSize();
		cardSize.setId(weddingCardBean.getCardSizeId());
		weddingCard.setCardSize(cardSize);

		weddingCard.setFrontImg(weddingCardBean.getFrontImg());
		weddingCard.setId(weddingCardBean.getId());
		weddingCard.setLastImg(weddingCardBean.getLastImg());
		weddingCard.setMainImg(weddingCardBean.getMainImg());
		weddingCard.setMiddleImg(weddingCardBean.getMiddleImg());
		weddingCard.setMinOrder(weddingCardBean.getMinOrder());
		weddingCard.setPriceLTHundred(weddingCardBean.getPriceLTHundred());
		weddingCard.setPriceGTHundred(weddingCardBean.getPriceGTHundred());

		WeddingCardFrontImage weddingCardFrontImage = new WeddingCardFrontImage();
		weddingCardFrontImage.setId(weddingCardBean
				.getWeddingCardFrontImageId());
		weddingCard.setWeddingCardFrontImage(weddingCardFrontImage);

		return weddingCard;
	}

	public WeddingCardBean entityToBean(WeddingCard weddingCard) {
		WeddingCardBean weddingCardBean = new WeddingCardBean();
		weddingCardBean.setActiveYear(weddingCard.getActiveYear().getYear());
		weddingCardBean.setActiveYearId(weddingCard.getActiveYear().getId());
		weddingCardBean.setCardNumber(weddingCard.getCardNumber());
		weddingCardBean.setCardType(weddingCard.getCardType().getType());
		weddingCardBean.setCardTypeId(weddingCard.getCardType().getId());
		weddingCardBean.setFrontImg(weddingCard.getFrontImg());
		weddingCardBean.setId(weddingCard.getId());
		weddingCardBean.setLastImg(weddingCard.getLastImg());
		weddingCardBean.setMainImg(weddingCard.getMainImg());
		weddingCardBean.setMiddleImg(weddingCard.getMiddleImg());
		weddingCardBean.setMinOrder(weddingCard.getMinOrder());
		weddingCardBean.setPriceGTHundred(weddingCard.getPriceGTHundred());
		weddingCardBean.setPriceLTHundred(weddingCard.getPriceLTHundred());
		weddingCardBean.setUserCast(weddingCard.getUserCast().getCast());
		weddingCardBean.setUserCastId(weddingCard.getUserCast().getId());
		weddingCardBean.setWeddingCardFrontImage(weddingCard
				.getWeddingCardFrontImage().getFrontImageName());
		weddingCardBean.setWeddingCardFrontImageId(weddingCard
				.getWeddingCardFrontImage().getId());
		weddingCardBean.setCardSize(weddingCard.getCardSize().getSize());
		weddingCardBean.setCardSizeId(weddingCard.getCardSize().getId());
		return weddingCardBean;
	}

}
