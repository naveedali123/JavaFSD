package com.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="screensizes")
public class ScreenSizes {
	
	@Id @GeneratedValue   
    @Column(name = "SCREENID")
    private long SCREENID;
    
    @Column(name = "size")
    private String size;
   
        
        public ScreenSizes() {
                
        }
        public ScreenSizes(String size) {
                this.SCREENID = 0;
                this.size = size;
        }
        
        public long getSCREENID() {return this.SCREENID; }
        public String getSize() { return this.size;}
        public void setSCREENID(long id) { this.SCREENID = id;}
        public void setSize(String size) { this.size = size;}
        
        
}
