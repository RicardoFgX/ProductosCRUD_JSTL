package com.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.modelo.Producto;
import com.servicio.ProductoServicio;
import com.servicio.ProductoServicioImpl;

/**
 * Servlet implementation class CrearProducto
 */
@WebServlet("/CrearProducto") // Anotación que define la URL del servlet
public class CrearProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProducto() {
        super();
        // Constructor por defecto
    }

    /**
     * Método GET: muestra un formulario para crear un nuevo producto
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("JSP/crearProducto.jsp");
    }

    /**
     * Método POST: procesa la solicitud para crear un nuevo producto
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CrearProducto.doPost");

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Double peso = Double.parseDouble(request.getParameter("peso"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        // Crear un nuevo objeto Producto con los datos proporcionados
        Producto nuevoProducto = new Producto(nombre, descripcion, peso, stock);

        // Llamar al servicio para crear el producto en la base de datos
        productoServicio.createProducto(nuevoProducto);

        // Redirigir a la página de exito
        response.sendRedirect("JSP/exito.jsp");
    }
}
