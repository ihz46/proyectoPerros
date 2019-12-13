package com.ipartek.formacion.model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;


public class ArrayPerroDAOtest {

	private static ArrayPerroDAO dao;
	private static Perro mock;
	private static int indice=1;
	private static final int MOCK_ID_INEXISTENTE=1;
	private static final String MOCK_NOMBRE = "pulgas";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao = ArrayPerroDAO.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		dao = null;
	
	}

	@Before
	public void setUp() throws Exception {
		
		mock = new Perro(indice, MOCK_NOMBRE);
		dao.create(mock);
		
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(mock.getId());
		mock = null;
	
	}

	@Test
	public void testGetAll() throws Exception {
		
		assertEquals(indice, dao.getAll().size());
		
		dao.delete(mock.getId());
		
		assertEquals("No deberia quedar ninguno", 0,dao.getAll().size());
		
	}

	@Test
	public void testGetById() {
		
		//Test para ver que pasa cuando metes un id no existente
		assertNull("Es imposible que exista ese perro", dao.getById(MOCK_ID_INEXISTENTE));
		
		
		//Comprobamos si existe el perro mock
		Perro p = dao.getById(indice);
		
		assertSame("Deberia de existir pulgas",p, mock);
		
	}

	@Test
	public void testDelete() {
		try {
			
			//Solucionar bug tearDown, creamos un perro, para eliminarlo
			Perro pEliminar = new Perro(345, "Toby");
			dao.create(pEliminar);
			Perro p = dao.delete(pEliminar.getId());
			
			//Compruebo que devuelva a pulgas 
			assertSame(p,pEliminar);
			
			//Compruebo que la lista este vacía
			assertEquals("No queda ninguno", 0,dao.getAll().size());
			
			dao.delete(MOCK_ID_INEXISTENTE);
			fail("Debería haber lanzado Excepción");
			
		} catch (Exception e) {
			assertTrue("Lanzada la excepción correctamente al eliminar perro inexistente" ,true);
		}
	}

	@Test
	public void testUpdate() {
		//TODO test para actualizar
	}

	@Test
	public void testCreate() {
		
		
	}

}
