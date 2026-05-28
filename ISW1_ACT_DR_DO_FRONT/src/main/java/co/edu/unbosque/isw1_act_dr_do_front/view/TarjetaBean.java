package co.edu.unbosque.isw1_act_dr_do_front.view;

import co.edu.unbosque.isw1_act_dr_do_front.model.TarjetaDTO;
import co.edu.unbosque.isw1_act_dr_do_front.services.interfaces.InterfaceTarjeta;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named("tarjetaBean")
@ViewScoped
public class TarjetaBean implements Serializable {

    private TarjetaDTO tarjetaDto;

    @Inject
    private InterfaceTarjeta tarjetaService;

    @PostConstruct
    public void init() {
        tarjetaDto = new TarjetaDTO();
    }

    public void registrarTarjeta() {
        boolean verificarExiste = verificarSiExisteTarjeta();
        boolean verificarCupo = verificarCupoTarjeta();
        boolean verificarNumTarjeta = verificarNumTarjeta();
        UUID uuid = UUID.randomUUID();

        if (!verificarExiste && verificarCupo && verificarNumTarjeta) {
            tarjetaDto.setCupoUtilizado(tarjetaDto.getCupoTotal() - tarjetaDto.getCupoDisponible());
            tarjetaDto.setId(uuid.toString());
            tarjetaDto.setEstado("ACTIVA");
            try {
                tarjetaService.registrar(tarjetaDto);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tarjeta registrada con exito: " + tarjetaDto);
            tarjetaDto = new TarjetaDTO();
        }
    }

    public List<TarjetaDTO> listarTarjetas() {
        return tarjetaService.listar();
    }

    public void actualizarTarjeta() throws JsonProcessingException {
        boolean verificarCupo = verificarCupoTarjeta();
        if (verificarCupo) {
            tarjetaDto.setCupoUtilizado(tarjetaDto.getCupoTotal() - tarjetaDto.getCupoDisponible());
            tarjetaService.actualizar(tarjetaDto, tarjetaDto.getId());
            System.out.println(tarjetaDto + " actualizada");
        }
    }

    public void cambiarEstadoTarjeta(TarjetaDTO tarjeta) throws JsonProcessingException {
        if (tarjeta.getEstado().equals("ACTIVA")) {
            tarjeta.setEstado("INACTIVA");
            System.out.println("Tarjeta inactivada: " + tarjeta);
        } else {
            tarjeta.setEstado("ACTIVA");
            System.out.println("Tarjeta activada: " + tarjeta);
        }
        tarjetaService.actualizar(tarjeta, tarjeta.getId());
    }

    public boolean verificarSiExisteTarjeta() {
        boolean existe = tarjetaService.buscar(tarjetaDto.getNumTarjeta());
        if (existe) {
            System.out.println("Tarjeta con numero: " + tarjetaDto.getNumTarjeta() + " ya existe, no se puede registrar");
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarCupoTarjeta() {
        if (tarjetaDto.getCupoTotal() < tarjetaDto.getCupoDisponible()) {
            System.out.println("Movimiento invalido, el cupo total tiene que ser mayor que el cupo disponible");
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarNumTarjeta() {
        String numeroTarjeta = tarjetaDto.getNumTarjeta();
        int longitud = numeroTarjeta.length();

        if (longitud == 19) {
            if (numeroTarjeta.matches("^5[1-5].*")) {
                tarjetaDto.setFranquicia("MASTERCARD");
                return true;
            } else if (numeroTarjeta.startsWith("4")) {
                tarjetaDto.setFranquicia("VISA");
                return true;
            }
        } else if (longitud == 18 && numeroTarjeta.matches("^3[47].*")) {
            tarjetaDto.setFranquicia("AMEX");
            return true;
        }
        System.out.println("Número de tarjeta inválido, no se puede registrar. Verifique el número de tarjeta.");
        FacesContext.getCurrentInstance().addMessage("formRegistro:numTarjeta",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Numero de Tarjeta Invalida", "Ingrese un numero valido"));
        return false;
    }

    public void crearTarjeta() {
        System.out.println("Creando tarjeta...");
    }

    public TarjetaDTO getTarjetaDto() {
        return tarjetaDto;
    }

    public void setTarjetaDto(TarjetaDTO tarjetaDto) {
        this.tarjetaDto = tarjetaDto;
        System.out.println(tarjetaDto.toString());
    }
}
