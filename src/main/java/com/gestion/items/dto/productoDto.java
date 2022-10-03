package com.gestion.items.dto;

public class productoDto {


    private String nombre;
    private String marca;
    private String hechoen;
    private Float precio;


    public productoDto(String nombre, String marca, String hechoen, Float precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.hechoen = hechoen;
        this.precio = precio;
    }


    public productoDto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHechoen() {
        return hechoen;
    }

    public void setHechoen(String hechoen) {
        this.hechoen = hechoen;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
