package com.duoc.restspringjpa.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.restspringjpa.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, String> {
	
	
	


}
