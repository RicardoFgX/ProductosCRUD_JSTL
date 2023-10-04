package com.servicio;

import java.util.List;

import com.modelo.Producto;

// Interfaz que define métodos para el servicio de productos
public interface ProductoServicio {
    
    // Método para crear un nuevo producto
    Boolean createProducto(Producto producto);

    // Método para obtener un producto por su ID
    Producto readProducto(int id);

    // Método para actualizar la información de un producto
    Boolean updateProducto(Producto producto);

    // Método para eliminar un producto por su ID
    Boolean deleteProducto(int id);

    // Método para obtener una lista de todos los productos
    List<Producto> getAllProducto();
}
