package com.unla.oo2.grupo2.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Cliente {
	
	private boolean clientePremium;

	public Cliente(boolean clientePremium) {
		super();
		this.clientePremium = clientePremium;
	}
	
	
}
