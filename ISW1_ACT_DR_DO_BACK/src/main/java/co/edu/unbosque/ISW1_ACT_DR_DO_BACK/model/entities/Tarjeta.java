package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

    @Id
    @Column(name = "ID_TARJETA")
    private String id;

    @Column(name = "NUM_TARJETA")
    private String numTarjeta;

    @Column(name = "FECHA_VENCIMIENTO")
    private String fechaVencimiento;

    @Column(name = "FRANQUICIA_TARJETA")
    private String franquicia;

    @Column(name = "ESTADO_TARJETA")
    private String estado;

    @Column(name = "CUPO_TOTAL")
    private int cupoTotal;

    @Column(name = "CUPO_DISPONIBLE")
    private int cupoDisponible;

    @Column(name = "CUPO_UTILIZADO")
    private int cupoUtilizado;

    public Tarjeta() {
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
}
