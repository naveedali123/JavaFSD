package com.ecommerce;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="eproduct")
public class eproduct {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private Double price;

	// ALT +S+R
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Double getprice() {
		return price;
	}

	public void setprice(Double price) {
		this.price = price;
	}
        
        
}
