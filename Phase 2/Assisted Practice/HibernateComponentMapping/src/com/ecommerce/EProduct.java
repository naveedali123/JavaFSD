package com.ecommerce;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Map;


@Entity
@Table(name="eproduct")
public class EProduct {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long ID;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="dateAdded")
	private Date dateAdded;
	
	@Column(name="parts")
	private ProductParts parts;
       
        
        public EProduct() {
                
        }
        
        public long getID() {return this.ID; }
        public String getName() { return this.name;}
        public BigDecimal getPrice() { return this.price;}
        public Date getDateAdded() { return this.dateAdded;}
        public ProductParts getParts() { return this.parts;}
        
        public void setID(long id) { this.ID = id;}
        public void setName(String name) { this.name = name;}
        public void setPrice(BigDecimal price) { this.price = price;}
        public void setDateAdded(Date date) { this.dateAdded = date;}
        public void setParts(ProductParts parts) { this.parts = parts;}
}
