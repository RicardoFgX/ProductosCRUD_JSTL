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
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		
		System.out.println("EliminarProducto.doPost id: "+id);

		try {

			if (productoServicio.deleteProducto(Integer.parseInt(id))) {
				response.sendRedirect("JSP/exito.jsp"); 
			} else {
				response.sendRedirect("JSP/error.jsp"); 
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			response.sendRedirect("JSP/error.jsp");
		}
	}

}
