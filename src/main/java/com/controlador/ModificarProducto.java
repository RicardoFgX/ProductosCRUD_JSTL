package com.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.modelo.Producto;
import com.servicio.ProductoServicio;
import com.servicio.ProductoServicioImpl;

/**
 * Servlet implementation class ModificarProducto
 */
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModificarProducto.doGet");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = productoServicio.readProducto(id);
            
      
            
            if (producto == null) {
                response.sendRedirect("error.jsp");
                return;
            }
        	request.setAttribute("producto", producto);
    		RequestDispatcher dispacher = request.getRequestDispatcher("JSP/editarProducto.jsp");
    		dispacher.forward(request, response);


        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp"); 
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModificarProducto.doPost");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double peso = Double.parseDouble(request.getParameter("peso"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            Producto nuevoProducto;
           
            nuevoProducto = new Producto(id, nombre, descripcion, peso, stock);
            System.out.println(nuevoProducto.toString());
            
            
            boolean actualizado = productoServicio.updateProducto(nuevoProducto);
            if (!actualizado) {
                response.sendRedirect("JSP/error.jsp");
                return;
            }
            
            response.sendRedirect("JSP/exito.jsp"); 

        } catch (NumberFormatException e) {
            response.sendRedirect("JSP/error.jsp"); 
        }
	}

}
