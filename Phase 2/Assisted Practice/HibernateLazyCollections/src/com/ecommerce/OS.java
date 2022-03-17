package com.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="os")
public class OS {

	@Id @GeneratedValue   
    @Column(name = "OSID")
    private long OSID;
    
    @Column(name = "name")
    private String name;
	
  
        
        public OS() {
                
        }
        public OS(String name) {
                this.OSID = 0;
                this.name = name;
        }
        
        public long getOSID() {return this.OSID; }
        public String getName() { return this.name;}
        public void setOSID(long id) { this.OSID = id;}
        public void setName(String name) { this.name= name;}
        
        
}
