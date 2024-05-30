
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Cliente;
import com.unla.oo2.grupo2.repository.IClienteRepository;

@Service
public class ClienteService {

@Autowired
IClienteRepository clienteRepo;

// Query
public Cliente getById(int id) {
	return clienteRepo.getReferenceById(id);
}

public List<Cliente> getAll()
{
	return clienteRepo.findAll();
}

//CUD
public int agregar(Cliente c) {
	return clienteRepo.save(c).getId();
	
}

public void delete(int id) {
	
	if(id != 0)
		clienteRepo.deleteById(id);
}

}
