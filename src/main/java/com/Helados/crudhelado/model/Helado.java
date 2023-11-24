package com.Helados.crudhelado.model;

public class Helado {
    public long id;
    public String sabor;
    public String tvaso;
    public double precio;
    public int disponibles;

    public Helado() {
        // Constructor vacío requerido por JPA u otros frameworks de persistencia.
    }
    public Helado(long id, String sabor, String tvaso, double precio, int disponibles) {
        this.id = id;
        this.sabor = sabor;
        this.tvaso = tvaso;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTvaso() {
        return tvaso;
    }

    public void setTvaso(String tvaso) {
        this.tvaso = tvaso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
}
