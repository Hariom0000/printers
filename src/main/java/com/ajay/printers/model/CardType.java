package com.ajay.printers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "card_type", uniqueConstraints = @UniqueConstraint(columnNames = "type"))
public class CardType extends AbstractPO<Integer> {

	private String type;

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
	@Column(name = "type")
	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}
}
