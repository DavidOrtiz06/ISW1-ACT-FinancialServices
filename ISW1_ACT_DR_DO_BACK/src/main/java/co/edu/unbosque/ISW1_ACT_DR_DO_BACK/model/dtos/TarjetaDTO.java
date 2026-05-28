package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.dtos;

public class TarjetaDTO {

    private String id;
    private String numTarjeta;
    private String fechaVencimiento;
    private String franquicia;
    private String estado;
    private int cupoTotal;
    private int cupoDisponible;
    private int cupoUtilizado;

    public TarjetaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(int cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public int getCupoUtilizado() {
        return cupoUtilizado;
    }

    public void setCupoUtilizado(int cupoUtilizado) {
        this.cupoUtilizado = cupoUtilizado;
    }

    @Override
    public String toString() {
        return "TarjetaDTO{" +
                "id=" + id +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                ", franquicia='" + franquicia + '\'' +
                ", estado='" + estado + '\'' +
                ", cupoTotal=" + cupoTotal +
                ", cupoDisponible=" + cupoDisponible +
                ", cupoUtilizado=" + cupoUtilizado +
                '}';
    }
}
