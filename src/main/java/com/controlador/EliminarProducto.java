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
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto") // Anotación que define la URL del servlet
public class EliminarProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // Constructor por defecto
    }

    /**
     * Método GET: no se utiliza en este servlet
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * Método POST: procesa la solicitud para eliminar un producto
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        System.out.println("EliminarProducto.doPost id: " + id);

        try {
            // Intenta eliminar el producto por su ID
            if (productoServicio.deleteProducto(Integer.parseInt(id))) {
                response.sendRedirect("JSP/exito.jsp"); // Redirige a la página de éxito si se eliminó correctamente
            } else {
                response.sendRedirect("JSP/error.jsp"); // Redirige a la página de error si no se pudo eliminar
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            response.sendRedirect("JSP/error.jsp"); // Redirige a la página de error en caso de excepción
        }
    }
}
