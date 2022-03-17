package com.ecommerce;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colors")
public class Color {
	
	@Id @GeneratedValue   
    @Column(name = "COLORID")
    private long COLORID;
    
    @Column(name = "name")
    private String name;
   
        
        public Color() {
                
        }
        public Color(String name) {
                this.COLORID = 0;
                this.name = name;
        }
        
        public long getCOLORID() {return this.COLORID; }
        public String getName() { return this.name;}
        public void setCOLORID(long id) { this.COLORID = id;}
        public void setName(String name) { this.name = name;}
        
        
}
