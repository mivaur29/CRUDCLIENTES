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

public class ListarTest {
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
	public void cuandoFindAllEntonces2() {
		int cuantos = this.dao.findAll().size();
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 2", cuantos == 2);
	}
	
	@Test
	public void cuandoAgregar1FindAllEntonces3() {
		Cliente cliente = new Cliente ("1983-1","mario","bross","clubnintendo@gmail.com","8008009000");
		this.dao.save(cliente);
		int cuantos = this.dao.findAll().size();
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 3", cuantos == 3);
	}
	
	@Test
	public void cuandoEliminar1FindAllEntonces1() {
		this.dao.deleteById("15538746-7");
		int cuantos = this.dao.findAll().size();
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 1", cuantos == 1);
	}
	
	@Test
	public void cuandoFindByIdEntoncesTieneTodosSusDatos() {
		Cliente miguel = this.dao.findById("15538746-7").get();
		Cliente miguelOriginal = new Cliente ("15538746-7","miguel","valdes","mivaur29@gmail.com","82049699");
		boolean sonIguales = miguel.equals(miguelOriginal);
		assertTrue(sonIguales);
		
		
	}


}
