package com.duoc.restspringjpa.test;

import static org.junit.Assert.*;

import java.util.List;

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


public class EliminarTest {
	
	
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
		cliente = new Cliente ("99999999-9","matias","oviedo","oviedo@gmail.com","7794833");
		this.entityManager.persist(cliente);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void cuandoNOExisteRegistroEntoncesSize3() {
		if(this.dao.existsById("1-1")) {
			
			this.dao.deleteById("15538746-7");
		}
		
		int cuantos = this.dao.findAll().size();
		System.out.println((this.dao.findAll().size()));
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 3", cuantos == 3);
		
		
	}
	
	@Test
	public void cuandoExisteRegistroEntoncesEliminarFalse() {
		if(this.dao.existsById("15538746-7")) {
			
			this.dao.deleteById("15538746-7");
		}
		System.out.println(this.dao.existsById("15538746-7"));
		assertFalse(this.dao.existsById("15538746-7"));
		
		
	}
	
	@Test
	public void cuandoRut99999EliminarTodoEntoncesSize0() {
		
		List<Cliente> lista = dao.findAll();
		if(lista.get(2).getRut()=="99999999-9") {
			
			dao.deleteAll();
		}
		
		int cuantos = this.dao.findAll().size();
		System.out.println("cuantos es 0 :"+ cuantos);
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 0", cuantos == 0);
		
		
	}
	
	
	
	



}
