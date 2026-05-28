package co.edu.unbosque.isw1_act_dr_do_front.services;

import co.edu.unbosque.isw1_act_dr_do_front.model.ActualizarCupoTarjetaDTO;
import co.edu.unbosque.isw1_act_dr_do_front.model.TarjetaDTO;
import co.edu.unbosque.isw1_act_dr_do_front.services.interfaces.InterfaceTarjeta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;
import java.util.List;

@Stateless
public class TarjetaService implements InterfaceTarjeta {

    private ApiService apiService;

    public TarjetaService() {
        apiService = new ApiService();
    }

    @Override
    public TarjetaDTO registrar(TarjetaDTO tarjeta) throws JsonProcessingException {
        return apiService.registrar("tarjetas", tarjeta, TarjetaDTO.class);
    }

    @Override
    public List<TarjetaDTO> listar() throws JsonProcessingException {
        return apiService.listar("tarjetas", TarjetaDTO.class);
    }

    @Override
    public TarjetaDTO actualizar(TarjetaDTO tarjeta, String id) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8081/financiera/api/tarjetas/" + id + "/cupo");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ActualizarCupoTarjetaDTO actualizarCupo = new ActualizarCupoTarjetaDTO();
        actualizarCupo.setCupoTotal(tarjeta.getCupoTotal());
        Response response = target.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(objectMapper.writeValueAsString(actualizarCupo), MediaType.APPLICATION_JSON));
        if (response.getStatus() == 201) {
            return objectMapper.readValue(response.readEntity(String.class), TarjetaDTO.class);
        } else {
            return null;
        }
    }
}
