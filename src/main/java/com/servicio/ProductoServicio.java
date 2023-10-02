package com.servicio;

import java.util.List;

import com.modelo.Producto;

public interface ProductoServicio {
	Boolean createProducto(Producto persona);

	Producto readProducto(int id);

	Boolean updateProducto(Producto persona);

	Boolean deleteProducto(int id);

	List<Producto> getAllProducto();
}
