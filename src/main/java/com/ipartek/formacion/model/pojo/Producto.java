package com.ipartek.formacion.model.pojo;

public class Producto {
	private int id;
	private String nombre;
	private double precio;
	private String imagen;
	private String descripcion;
	private int descuento;
	
	
	private Producto() {
		super();
		this.id = 1;
		this.nombre = "";
		this.precio = 0.0;
		this.imagen = "";
		this.descripcion = "";
		this.descuento = 0;
	}


	private Producto(int id, String nombre, double precio, String imagen, String descripcion, int descuento) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}


	private Producto(String nombre, double precio, String imagen, String descripcion, int descuento) {
		this();
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", descuento=" + descuento + "]";
	}
	
	
	
	
	
	
	
	
}
