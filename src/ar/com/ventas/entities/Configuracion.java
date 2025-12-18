/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Mario
 */
public class Configuracion {
    private Long id;
    private Integer sucursal;
    private Integer numeroFc;
    private Integer numeroNc;

    public Configuracion() {
    }

    public Configuracion(Long id, Integer sucursal, Integer numeroFc, Integer numeroNc) {
        this.id = id;
        this.sucursal = sucursal;
        this.numeroFc = numeroFc;
        this.numeroNc = numeroNc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumeroFc() {
        return numeroFc;
    }

    public void setNumeroFc(Integer numeroFc) {
        this.numeroFc = numeroFc;
    }

    public Integer getNumeroNc() {
        return numeroNc;
    }

    public void setNumeroNc(Integer numeroNc) {
        this.numeroNc = numeroNc;
    }

}