package com.ipartek;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {
		assertTrue(2 == 2);
		assertEquals(2, 2);
		
		HashSet<String> paises = new HashSet<String>();
		
		assertNotNull("no deberia ser null", paises);
		paises.add("es");
		paises.add("us");
		paises.add("ru");
		paises.add("fr");
		paises.add("es");
		paises.add("us");
		paises.add("ru");
		paises.add("fr");
		
		assertEquals("No debería haber duplicados",4, paises.size());
	
	
	}

}
