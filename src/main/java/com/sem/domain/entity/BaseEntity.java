package com.sem.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class BaseEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5612152055101488215L;

	@Temporal(TemporalType.DATE)
    private Date created;

    @Temporal(TemporalType.DATE)
    private Date modified;
    
    
	public Date getCreated() {
		return created;
	}

	public Date getModified() {
		return modified;
	}
	
    @PrePersist
    protected void onCreate() {
    	modified = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	modified = new Date();
    }	
}
