package co.edu.unbosque.isw1_act_dr_do_front.services.interfaces;

import co.edu.unbosque.isw1_act_dr_do_front.model.TarjetaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface InterfaceTarjeta extends InterfaceService<TarjetaDTO> {

    TarjetaDTO actualizar(TarjetaDTO tarjeta, String id) throws JsonProcessingException;
}
