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
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("JSP/crearProducto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CrearProducto.doPost");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Double peso = Double.parseDouble(request.getParameter("peso"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto nuevoProducto = new Producto(nombre, descripcion, peso, stock);
		productoServicio.createProducto(nuevoProducto);
		response.sendRedirect("JSP/exito.jsp");
	}

}
