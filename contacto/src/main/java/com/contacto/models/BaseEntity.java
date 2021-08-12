package com.contacto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // TODO: Learn others
	Long id;
	
	@Column(name = "creation_time")
	Date creationTime;
	
	/**
	 * Set creation time before saving entity to database
	 */
	@PrePersist
	protected void onCreate() {
		if(this.creationTime == null)
			this.creationTime = new Date();
	}
}
