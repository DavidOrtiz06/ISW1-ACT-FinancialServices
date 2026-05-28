package co.edu.unbosque.isw1_act_dr_do_front.model;

public class ClienteDTO {

    private String id;
    private String numeroIdentificacion;
    private String correo;
    private String nombreCompleto;
    private TarjetaDTO tarjeta;

    public ClienteDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TarjetaDTO getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDTO tarjeta) {
        this.tarjeta = tarjeta;
    }
}