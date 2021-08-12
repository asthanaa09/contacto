package com.contacto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    public enum RoleType {
		ROLE_STUDENT, 
		ROLE_TEACHER,
		/**
		 * Allows User to manage application
		 */
		ROLE_ADMIN
    }

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private RoleType roleType;
}

