# Proyecto de Aplicación Web de Gestión de Productos

Este proyecto tiene como objetivo desarrollar una aplicación web Java que permita realizar operaciones CRUD (Create, Read, Update, Delete) sobre un objeto "Producto". La aplicación utiliza tecnologías como JSP y Servlets para la interfaz de usuario y el controlador, respectivamente, y se conecta a una base de datos MySQL mediante JDBC para almacenar y recuperar información sobre los productos.

## Requisitos del Proyecto

### Modelo de Datos - Producto

El objeto "Producto" tiene las siguientes propiedades:

- Nombre
- Descripción
- Peso
- Stock

### Aplicación Web

La aplicación web se desarrolla utilizando las siguientes tecnologías y enfoques:

- JSP (JavaServer Pages) para las vistas de usuario.
- Servlets para gestionar las solicitudes del usuario y realizar operaciones CRUD.
- Java para la lógica de negocio.

### Conexión a MySQL

La aplicación se conecta a una base de datos MySQL para almacenar y recuperar información sobre los productos. Se utiliza JDBC (Java Database Connectivity) para establecer la conexión y realizar operaciones en la base de datos.

### Funcionalidad Completa de CRUD

El proyecto implementa la funcionalidad completa de CRUD (Create, Read, Update, Delete) para los productos. Los usuarios pueden realizar las siguientes acciones:

- Crear un nuevo producto.
- Leer los detalles de un producto existente.
- Actualizar la información de un producto.
- Eliminar un producto de la base de datos.

### Script SQL

El script SQL que define y configura la base de datos utilizada se proporciona en un archivo separado llamado "script.sql". Este script debe ser ejecutado en un servidor MySQL para configurar la estructura de la base de datos y crear las tablas necesarias para almacenar los productos.

## Configuración y Ejecución

Para configurar y ejecutar la aplicación, sigue estos pasos:

1. Clona o descarga este repositorio en tu entorno de desarrollo.

2. Configura la base de datos MySQL utilizando el script SQL proporcionado en el archivo "script.sql".

3. Abre el proyecto en tu entorno de desarrollo Java preferido.

4. Configura la conexión a la base de datos.

5. Ejecuta la aplicación en un servidor web compatible con Java, como Apache Tomcat.

6. Abre un navegador web y accede a la URL de la aplicación para comenzar a gestionar productos.

## Autor

Este proyecto fue desarrollado por Ricardo Fernández Guzmán.
