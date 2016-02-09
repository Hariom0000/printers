package com.ajay.printers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "wedding_card_front_image", uniqueConstraints = @UniqueConstraint(columnNames = "front_image_name"))
public class WeddingCardFrontImage extends AbstractPO<Integer> {

	private static final long serialVersionUID = 1L;
	private String frontImageName;;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "front_image_name")
	public String getFrontImageName() {
		return frontImageName;
	}

	public void setFrontImageName(String frontImageName) {
		this.frontImageName = frontImageName;
	}

}
