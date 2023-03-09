package com.OBSpringBoot.Ejercicio101112.Entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "Laptops Stock")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clave;
    private String marca;
    private String modelo;
    private double precio;
    private boolean online;

    public Laptop(){}

    public Laptop(Long id, String clave, String marca, String modelo, double precio, boolean online) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.online = online;
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getClave() {
        return clave;
}
    public void setClave(String clave){
        this.clave = clave;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
