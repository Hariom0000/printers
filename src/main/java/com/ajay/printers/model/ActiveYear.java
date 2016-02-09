package com.ajay.printers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "active_year", uniqueConstraints = @UniqueConstraint(columnNames = "year"))
public class ActiveYear extends AbstractPO<Integer>{

	private static final long serialVersionUID = 1L;
	private String year;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
	}
	@Column(name = "year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
