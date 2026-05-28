package co.edu.unbosque.isw1_act_dr_do_front.model;

import java.io.Serializable;

public class ActualizarCupoTarjetaDTO implements Serializable {

    private Integer cupoTotal;

    public ActualizarCupoTarjetaDTO() {}

    public Integer getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(Integer cupoTotal) {
        this.cupoTotal = cupoTotal;
    }
}
