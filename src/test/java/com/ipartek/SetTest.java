package com.ipartek;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;

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
	
		Perro p = new Perro("mock");
		assertEquals(0, p.getId());
		assertEquals("mock", p.getNombre());
		assertEquals("https://images.squarespace-cdn.com/content/v1/5a8abbee6f4ca301c2d1b962/1527808340868-GRA08XX79G20DUND6H9I/ke17ZwdGBToddI8pDm48kGuaBMmARhKtUmXCE1pY_k1Zw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZUJFbgE-7XRK3dMEBRBhUpzGBwVodEh3vUCb_FH6fADYhlZwvRiPtE8wFqmckfQo9hcWrJuBgPcO-nCQUzImAEM/Logo+Pipper+RECORTADA.jpg", p.getFoto());
		
	}

}
