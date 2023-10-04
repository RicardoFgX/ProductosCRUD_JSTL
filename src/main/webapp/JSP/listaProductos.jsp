<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Importación de las bibliotecas de etiquetas JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <!-- Configuración del documento -->
    <meta charset="UTF-8">
    <title>Listado Productos</title>
    
    <!-- Enlace al archivo CSS para estilos -->
    <link rel="stylesheet" type="text/css" href="CSS/listaProductos.css">
</head>

<body>
    <!-- Título de la página -->
    <h1>Listado de Productos</h1>

    <!-- Tabla para mostrar la lista de productos -->
    <table>
        <thead>
            <!-- Encabezados de la tabla -->
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Peso</th>
            <th>Stock</th>
        </thead>
        <tbody>
            <!-- Itera sobre la lista de productos -->
            <c:forEach var="producto" items="${PRODUCTOS}">
                <tr>
                    <!-- Datos de cada producto -->
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.descripcion}</td>
                    <td>${producto.peso}</td>
                    <td>${producto.stock}</td>

                    <td>
                        <!-- Botón para modificar el producto -->
                        <jsp:include page="elementos/botonModificar.jsp">
                            <jsp:param name="id" value="${producto.id}" />
                        </jsp:include>
                        
                        <!-- Botón para eliminar el producto -->
                        <jsp:include page="elementos/botonEliminar.jsp">
                            <jsp:param name="id" value="${producto.id}" />
                        </jsp:include>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- Enlace para crear un nuevo producto -->
    <ul>
        <li><a href="CrearProducto">Nuevo Producto</a></li>
    </ul>
</body>

</html>
