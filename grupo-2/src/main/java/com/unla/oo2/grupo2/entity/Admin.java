package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Admin {
	private long cuil;

	public Admin(long cuil) {
		super();
		this.cuil = cuil;
	}
	
	
	
}
