
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Cliente;
import com.unla.oo2.grupo2.repository.IClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	// Query
	public Cliente getById(int id) {
		return clienteRepository.getReferenceById(id);
	}

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	//CUD
	public int agregar(Cliente c) {
		return clienteRepository.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			clienteRepository.deleteById(id);
	}

}
