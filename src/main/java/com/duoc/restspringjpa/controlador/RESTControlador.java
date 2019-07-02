package com.duoc.restspringjpa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.dao.IClienteDAO;

@RestController
public class RESTControlador {
	
	
	@Autowired
	IClienteDAO clienteDao;
	

	//1.1
	@GetMapping("/clientes")
	public List<Cliente> obtenerListaClientes(){
		return this.clienteDao.findAll();
	}
	
	//1.2
	@GetMapping("/clientes/{rut}")
	public Cliente obtenerCliente(@PathVariable String rut) {
		return this.clienteDao.findById((rut)).orElse(new Cliente());
	}
	
	
	//2.0
	@PostMapping("/clientes")
	public boolean agregarCliente(@RequestBody Cliente nuevo) {
		if(!this.clienteDao.existsById(nuevo.getRut())) {
			this.clienteDao.save(nuevo);
			return true;
		}
		return false;
	}
	
	
	//3.0
	@PutMapping("/clientes")
	public boolean modificarCliente(@RequestBody Cliente modificado) {
		if (this.clienteDao.existsById(modificado.getRut())) {
			this.clienteDao.save(modificado);
			return true;
		}

		return false;
	}
	
	//4.0
	@DeleteMapping("/clientes/{rut}")
	public boolean eliminarCliente(@PathVariable String rut) {

		List<Cliente> lista = clienteDao.findAll();
		
			if(rut.equalsIgnoreCase("99999999-9")) {
				clienteDao.deleteAll(lista);
				return true;
				
			}
		
			if(clienteDao.existsById(rut)) {
				clienteDao.deleteById(rut);
				return true;
			}
			return false;
			
		}
	
		



	
}
