package com.servicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Producto;

public class ProductoServicioImpl implements ProductoServicio {

	private static ProductoServicioImpl instancia;
	private final String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
	private final String user = "root";
	private final String password = "1234";

	public ProductoServicioImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized ProductoServicioImpl obtenerInstancia() {
		if (instancia == null) {
			instancia = new ProductoServicioImpl();
		}
		return instancia;
	}

	@Override
	public Boolean createProducto(Producto producto) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			String sql = "INSERT INTO productos (nombre, descripcion, peso, stock) VALUES (?, ?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, producto.getNombre());
				statement.setString(2, producto.getDescripcion());
				statement.setDouble(3, producto.getPeso());
				statement.setInt(4, producto.getStock());
				int rowsInserted = statement.executeUpdate();
				return rowsInserted > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Producto> getAllProducto() {
		List<Producto> productos = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM productos";
			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					Producto producto = new Producto(resultSet.getInt("id"), resultSet.getString("nombre"),
							resultSet.getString("descripcion"), resultSet.getDouble("peso"), resultSet.getInt("stock"));
					productos.add(producto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public Producto readProducto(int id) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM productos WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						String nombre = resultSet.getString("nombre");
						String descripcion = resultSet.getString("descripcion");
						Double peso = resultSet.getDouble("peso");
						int stock = resultSet.getInt("stock");
						return new Producto(id, nombre, descripcion, peso, stock);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateProducto(Producto producto) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			String sql = "UPDATE productos SET nombre = ?, descripcion = ?, peso = ?, stock = ? WHERE id = ?";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, producto.getNombre());
				statement.setString(2, producto.getDescripcion());
				statement.setDouble(3, producto.getPeso());
				statement.setInt(4, producto.getStock());
				statement.setLong(5, producto.getId());
				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Boolean deleteProducto(int id) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
		      
        	String sql = "DELETE FROM productos WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

}
