package com.ajay.printers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_cast", uniqueConstraints = @UniqueConstraint(columnNames = "cast"))
public class UserCast extends AbstractPO<Integer> {

	private static final long serialVersionUID = 1L;
	private String cast;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cast")
	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

}
