package com.ecommerce.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eproduct")
public class Eproduct {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int ID;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private Double price;

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
		
}

