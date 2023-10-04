<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Crear Producto</title>
    <meta charset="UTF-8">

    <!-- Enlace al archivo CSS para estilos -->
    <link rel="stylesheet" type="text/css" href="CSS/crearProducto.css">
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #0077cc;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #0056a8;
        }

    </style>
</head>

<body>
    <h2>Crear Producto</h2>

    <!-- Formulario para crear un producto -->
    <form action="${pageContext.request.contextPath}/CrearProducto" method="post">
        <!-- Campo de entrada para el nombre del producto -->
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>

        <!-- Campo de entrada para la descripción del producto -->
        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" required><br>

        <!-- Campo de entrada para el peso del producto -->
        <label for="peso">Peso:</label>
        <input type="text" id="peso" name="peso" required><br>

        <!-- Campo de entrada para el stock del producto -->
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock" required><br>

        <!-- Botón de envío del formulario -->
        <input type="submit" value="Crear">
    </form>
</body>

</html>
