package com.gestion.items.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 60)
    private String nombre;
    @Column(nullable = false, length = 60)
    private String tipo;
    @Column(nullable = false, length = 60)
    private String envase;
    @Column(nullable = false)
    private Integer capacidad;
    @Column(nullable = false)
    private Boolean nevera;
    @Column(nullable = false)
    private Integer estado;
    @Column(nullable = false)
    private LocalDateTime fecha2;


    public Item(long id, String nombre, String tipo, String envase, Integer capacidad, Boolean nevera, Integer estado, LocalDateTime fecha2) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.envase = envase;
        this.capacidad = capacidad;
        this.nevera = nevera;
        this.estado = estado;
        this.fecha2 = fecha2;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha2() {
        return fecha2;
    }

    public void setFecha2(LocalDateTime fecha2) {
        this.fecha2 = fecha2;
    }
}
