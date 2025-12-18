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
public class Direccion {
    private Long id;
    private String calle;
    private String numero;
    private String pisoDto;
    private String codigoPostal;
    private String localidad;
    private String provincia;

    public Direccion() {
    }

    public Direccion(Long id, String calle, String numero, String pisoDto, String codigoPostal, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.pisoDto = pisoDto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPisoDto() {
        return pisoDto;
    }

    public void setPisoDto(String pisoDto) {
        this.pisoDto = pisoDto;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
