CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    peso DECIMAL(10, 2),
    stock INT
);

INSERT INTO productos (nombre, descripcion, peso, stock) VALUES
('Producto 1', 'Descripción del Producto 1', 2.5, 10),
('Producto 2', 'Descripción del Producto 2', 1.8, 15),
('Producto 3', 'Descripción del Producto 3', 3.2, 8),
('Producto 4', 'Descripción del Producto 4', 0.5, 20),
('Producto 5', 'Descripción del Producto 5', 2.0, 12);