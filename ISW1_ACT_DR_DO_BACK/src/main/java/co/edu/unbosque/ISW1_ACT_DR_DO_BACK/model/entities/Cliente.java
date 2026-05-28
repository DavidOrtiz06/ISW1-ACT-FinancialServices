package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @Column(name = "ID_CLIENTE")
    private String id;

    @Column(name = "NUM_IDENTIFICACION")
    private String numeroIdentificacion;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @ManyToOne
    @JoinColumn(name = "ID_TARJETA")
    private Tarjeta tarjeta;

    public Cliente() {
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

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
