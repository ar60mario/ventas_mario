package ar.com.ventas.entities;

public class RenglonFacturaParaExcel {

    private Long id;
    private Integer rubro;
    private String texto;
    private String textoCorto;
    private Double importe;
    private Boolean activo;

    public RenglonFacturaParaExcel() {
    }

    public RenglonFacturaParaExcel(Long id, Integer rubro, String texto, String textoCorto, Double importe, Boolean activo) {
        this.id = id;
        this.rubro = rubro;
        this.texto = texto;
        this.textoCorto = textoCorto;
        this.importe = importe;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRubro() {
        return rubro;
    }

    public void setRubro(Integer rubro) {
        this.rubro = rubro;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoCorto() {
        return textoCorto;
    }

    public void setTextoCorto(String textoCorto) {
        this.textoCorto = textoCorto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
