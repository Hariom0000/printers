package com.ajay.printers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "wedding_card")
public class WeddingCard extends AbstractPO<Integer> {

	private String cardNumber;
	private ActiveYear activeYear;
	private CardType cardType;
	private WeddingCardFrontImage weddingCardFrontImage;
	private UserCast userCast;
	private Integer minOrder;
	private Integer priceLTHundred;
	private Integer priceGTHundred;
	private String mainImg;
	private String frontImg;
	private String middleImg;
	private String lastImg;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_type", nullable = false)
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@Column(name = "min_order")
	public Integer getMinOrder() {
		return minOrder;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_cast", nullable = false)
	public UserCast getUserCast() {
		return userCast;
	}

	public void setUserCast(UserCast userCast) {
		this.userCast = userCast;
	}

	public void setMinOrder(Integer minOrder) {
		this.minOrder = minOrder;
	}

	@Column(name = "main_image")
	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	@Column(name = "front_image")
	public String getFrontImg() {
		return frontImg;
	}

	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}

	@Column(name = "middle_image")
	public String getMiddleImg() {
		return middleImg;
	}

	public void setMiddleImg(String middleImg) {
		this.middleImg = middleImg;
	}

	@Column(name = "last_image")
	public String getLastImg() {
		return lastImg;
	}

	public void setLastImg(String lastImg) {
		this.lastImg = lastImg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "active_year", nullable = false)
	public ActiveYear getActiveYear() {
		return activeYear;
	}

	public void setActiveYear(ActiveYear activeYear) {
		this.activeYear = activeYear;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wedding_card_front_image", nullable = false)
	public WeddingCardFrontImage getWeddingCardFrontImage() {
		return weddingCardFrontImage;
	}

	public void setWeddingCardFrontImage(
			WeddingCardFrontImage weddingCardFrontImage) {
		this.weddingCardFrontImage = weddingCardFrontImage;
	}

	@Column(name = "price_lt_100")
	public Integer getPriceLTHundred() {
		return priceLTHundred;
	}

	public void setPriceLTHundred(Integer priceLTHundred) {
		this.priceLTHundred = priceLTHundred;
	}

	@Column(name = "price_gt_100")
	public Integer getPriceGTHundred() {
		return priceGTHundred;
	}

	public void setPriceGTHundred(Integer priceGTHundred) {
		this.priceGTHundred = priceGTHundred;
	}

}
