package com.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finance")
public class Finance {
	
	@Id @GeneratedValue   
    @Column(name = "FINANCEID")
    private long FINANCEID;
    
    @Column(name = "name")
    private String name;
	
    @Column(name = "ftype")
    private String ftype;
       
    
        
        public Finance() {
                
        }
        public Finance(String name, String ftype) {
                this.FINANCEID = 0;
                this.name = name;
                this.ftype = ftype;
        }
        
        public long getFINANCEID() {return this.FINANCEID; }
        public String getName() { return this.name;}
        public String getFtype() { return this.ftype;}
        public void setFINANCEID(long id) { this.FINANCEID = id;}
        public void setName(String name) { this.name = name;}
        public void setFtype(String ftype) { this.ftype= ftype;}
        
        
}
