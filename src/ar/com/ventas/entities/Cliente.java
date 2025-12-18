package ar.com.ventas.entities;

public class Cliente {

    private Long id;
    private Integer codigo;
    private String razonSocial;
    private Integer tipoDoc;
    private String cuit;
    private Boolean activo;
    private Integer categoriaAfip;
    private Direccion direccion;
    private Abono abono;
    private Boolean generado;
    private String codigoMauro;

    public Cliente() {
    }

    public Cliente(Long id, Integer codigo, String razonSocial, Integer tipoDoc, String cuit, Boolean activo, Integer categoriaAfip, Direccion direccion, Abono abono, Boolean generado, String codigoMauro) {
        this.id = id;
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        this.tipoDoc = tipoDoc;
        this.cuit = cuit;
        this.activo = activo;
        this.categoriaAfip = categoriaAfip;
        this.direccion = direccion;
        this.abono = abono;
        this.generado = generado;
        this.codigoMauro = codigoMauro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Integer tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getCategoriaAfip() {
        return categoriaAfip;
    }

    public void setCategoriaAfip(Integer categoriaAfip) {
        this.categoriaAfip = categoriaAfip;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }

    public Boolean getGenerado() {
        return generado;
    }

    public void setGenerado(Boolean generado) {
        this.generado = generado;
    }

    public String getCodigoMauro() {
        return codigoMauro;
    }

    public void setCodigoMauro(String codigoMauro) {
        this.codigoMauro = codigoMauro;
    }
}
