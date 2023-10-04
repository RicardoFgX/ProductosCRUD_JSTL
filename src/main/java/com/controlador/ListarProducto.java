package com.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.modelo.Producto;
import com.servicio.ProductoServicio;
import com.servicio.ProductoServicioImpl;

/**
 * Servlet implementation class ListarProducto
 */
@WebServlet("/ListarProducto") // Anotación que define la URL del servlet
public class ListarProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProducto() {
        super();
        // Constructor por defecto
    }

    /**
     * Método GET: muestra la lista de productos
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ListarProducto.doGET");

        // Obtener la lista de todos los productos
        List<Producto> productos = servicio.getAllProducto();

        // Agregar la lista de productos al request para mostrarla en la vista
        request.setAttribute("PRODUCTOS", productos);

        // Redirigir a la página JSP que muestra la lista de productos
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listaProductos.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Método POST: procesa la solicitud para filtrar la lista de productos
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ListarProducto.doPost");

        // Verificar si se debe filtrar la lista de productos
        boolean filtrarMenores = "true".equals(request.getParameter("filter"));

        // Obtener la lista de todos los productos
        List<Producto> productos = servicio.getAllProducto();

        // Filtrar la lista de productos si es necesario
        if (filtrarMenores) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);

            productos = productos.stream()
                    .filter(p -> p.getPeso() < 18.0) // Filtrar productos con peso menor a 18.0
                    .collect(Collectors.toList());
        }

        // Agregar la lista de productos al request para mostrarla en la vista
        request.setAttribute("PRODUCTOS", productos);

        // Redirigir a la página JSP que muestra la lista de productos
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listaProductos.jsp");
        dispatcher.forward(request, response);
    }
}
