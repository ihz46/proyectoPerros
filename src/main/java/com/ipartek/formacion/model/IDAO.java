package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Perro;

public interface IDAO<P> {
	
	/**
	 * Obtiene todos los datos	 * 
	 * @return lista de pojos
	 */
	List<P> getAll();
	
	/**
	 * Recupera un dato por su identificador
	 * @param id identificador
	 * @return pojo si lo encuentra y sino null
	 */
	P getById(int id);
	
	/**
	 * Elimina un pojo del id pasado como argumento.
	 * 
	 * @param id
	 * @return pojo si se elimina 
	 * @throws excepcion si no se puede eliminar o no se ha encontrado el elemento
	 */
	P delete(int id) throws Exception;
	
	/**
	 * Actualiza un pojo pasado por parámetro
	 * @param pojo contiene los datos a modificar
	 * @return pojo actualizado si sepuede modificar 
	 * @throws Exception si no se puede modificar o no lo encuentra
	 */
	
	P update(P pojo) throws Exception;
	
	/**
	 * Crea un pojo pasado por parámetro.
	 * @param pojo
	 * @return pojo si se crea y sino null
	 * @throws Exception 
	 */
	P create(P pojo) throws Exception;
}
