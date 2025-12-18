/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class Factura {
    private Long id;
    private Date fecha;
    private Cliente cliente;
    private Integer tipoDoc;
    private Integer sucursal;
    private Integer numero;
    private Double importe;
    private Long cae;
    private Date fechaVencimCae;
    private Integer numeroReferencia;

    public Factura() {
    }

    public Factura(Long id, Date fecha, Cliente cliente, Integer tipoDoc, Integer sucursal, Integer numero, Double importe, Long cae, Date fechaVencimCae, Integer numeroReferencia) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipoDoc = tipoDoc;
        this.sucursal = sucursal;
        this.numero = numero;
        this.importe = importe;
        this.cae = cae;
        this.fechaVencimCae = fechaVencimCae;
        this.numeroReferencia = numeroReferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Integer tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Long getCae() {
        return cae;
    }

    public void setCae(Long cae) {
        this.cae = cae;
    }

    public Date getFechaVencimCae() {
        return fechaVencimCae;
    }

    public void setFechaVencimCae(Date fechaVencimCae) {
        this.fechaVencimCae = fechaVencimCae;
    }
    
    public Integer getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(Integer numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }
}
