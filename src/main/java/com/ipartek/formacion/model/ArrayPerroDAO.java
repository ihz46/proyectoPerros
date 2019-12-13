package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Perro;
import com.mysql.fabric.xmlrpc.base.Array;

public class ArrayPerroDAO implements IDAO<Perro>{
	
	private static ArrayPerroDAO INSTANCE = null;
	private ArrayList<Perro> listaPerros;
	private static int indice = 1;
	

	
	//Capamos para que no podamos hacer new de esta clase.
	private ArrayPerroDAO() {
		
		super();
		listaPerros = new ArrayList<Perro>();
		
	}
	
	public synchronized static ArrayPerroDAO getInstance() {
		
		if (INSTANCE==null) {
			INSTANCE = new ArrayPerroDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public List<Perro> getAll() {
		
		return listaPerros;
	}

	@Override
	public Perro getById(int id) {
		Perro resultado = null;
		for (Perro perro : listaPerros) {
			if (id==perro.getId()) {
				resultado=perro;
				break;
			}
		}
		
		return resultado;
	}

	@Override
	public Perro delete(int id) throws Exception {
		
		Perro resultado = null;
		for (Perro perro : listaPerros) {
			if (id==perro.getId()) {
				resultado=perro;
				listaPerros.remove(perro);
				break;
			}
		}
		
		if (resultado==null) {
			throw new Exception("Perro no encontrado por su id");
			
		}
		
		return resultado;
	}
	

	@Override
	public Perro update(Perro pojo) throws Exception {
		Perro resultado = null;
		for (int i = 0; i < listaPerros.size(); i++) {
			
			if (pojo.getId() == listaPerros.get(i).getId()) {
				
				listaPerros.remove(i);
				listaPerros.add(pojo);
				resultado = pojo;
				
				break;
			}
			
		}
		
		if (resultado==null) {
			throw new Exception("No se ha encontrado al perro con el id" + pojo.getId());
		}
		
		return resultado;
	}

	@Override
	public Perro create(Perro pojo) throws Exception {
		Perro resultado = pojo;
		
		if (pojo!=null) {
			pojo.setId(++indice);
			
			listaPerros.add(pojo);
			
		}else {
			throw new Exception("Perro null");
		}
		
		return resultado;
	}

}
