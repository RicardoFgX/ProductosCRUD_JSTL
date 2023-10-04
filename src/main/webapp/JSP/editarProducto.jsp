<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Editar Producto</title>
    
    <!-- Enlace al archivo CSS para estilos -->
    <link rel="stylesheet" type="text/css" href="CSS/editarProducto.css">
</head>

<body>
    <h2>Editar Producto</h2>

    <!-- Formulario para editar un producto -->
    <form action="${pageContext.request.contextPath}/ModificarProducto" method="post">
        
        <!-- Comprueba si la variable "producto" no está vacía -->
        <c:if test="${not empty producto}">
            <!-- Campo oculto para almacenar el ID del producto -->
            <input type="hidden" name="id" value="${producto.id}" />
        </c:if>

        <!-- Campo de entrada para el nombre del producto -->
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${producto.nombre}" required><br>

        <!-- Campo de entrada para la descripción del producto -->
        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" value="${producto.descripcion}" required><br>

        <!-- Campo de entrada para el peso del producto -->
        <label for="peso">Peso:</label>
        <input type="text" id="peso" name="peso" value="${producto.peso}" required><br>

        <!-- Campo de entrada para el stock del producto -->
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock" value="${producto.stock}" required><br>

        <!-- Botón de envío del formulario para guardar los cambios -->
        <input type="submit" value="Guardar">
    </form>
</body>

</html>
