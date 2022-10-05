package com.gestion.items.dto;

public class ItemDto {



    private String nombre;
    private String tipo;
    private String envase;
    private Integer capacidad;
    private Boolean nevera;

    public ItemDto(String nombre, String tipo, String envase, Integer capacidad, Boolean nevera) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.envase = envase;
        this.capacidad = capacidad;
        this.nevera = nevera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getNevera() {
        return nevera;
    }

    public void setNevera(Boolean nevera) {
        this.nevera = nevera;
    }
}
