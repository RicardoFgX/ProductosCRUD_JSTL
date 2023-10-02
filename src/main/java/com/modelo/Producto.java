package com.modelo;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double peso;
    private int stock;

    // Constructor sin parámetros
    public Producto() {
    }

    // Constructor con todos los atributos
    public Producto(int id, String nombre, String descripcion, double peso, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peso = peso;
        this.stock = stock;
    }

    // Constructor sin el ID 
    public Producto(String nombre, String descripcion, double peso, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peso = peso;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", stock=" + stock +
                '}';
    }
}

