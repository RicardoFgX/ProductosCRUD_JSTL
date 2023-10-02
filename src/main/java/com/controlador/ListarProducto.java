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
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ListarProducto.doGET");

		List<Producto> producto = servicio.getAllProducto();
		request.setAttribute("PRODUCTOS", producto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listaProductos.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("ListarProducto.doPost");
		
		
		boolean filtrarMenores = "true".equals(request.getParameter("filter"));
		
		List<Producto> producto = servicio.getAllProducto();
		
		
		
		request.setAttribute("PRODUCTOS", producto);
		RequestDispatcher dispacher = request.getRequestDispatcher("JSP/listaProductos.jsp");
		dispacher.forward(request, response);
	}

}
