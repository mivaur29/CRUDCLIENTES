package com.duoc.restspringjpa.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.dao.IClienteDAO;


@RunWith(SpringRunner.class)
@DataJpaTest


public class ModificarTest {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente ("15538746-7","miguel","valdes","mivaur29@gmail.com","82049699");
		this.entityManager.persist(cliente);
		cliente = new Cliente ("7687098-5","monica","urtubia","murtubiagg@gmail.com","91594833");
		this.entityManager.persist(cliente);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void modificarNombreNoNull() {
		
		Cliente modificado = this.dao.findById("7687098-5").get();
		modificado.setNombres("Maria");
		this.dao.save(modificado);
		assertNotNull(this.dao.findById("Maria"));	
	}
	
	@Test
	public void modificarApellidoNoNull() {
		
		Cliente modificado = this.dao.findById("7687098-5").get();
		modificado.setApellidos("Romo");
		this.dao.save(modificado);
		assertNotNull(modificado.getApellidos()=="Romo");	
	}
	

	
	



}
