package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.controller;

import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.dtos.TarjetaDTO;
import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.services.TarjetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financiera/api")
public class TarjetaController {

    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/tarjetas")
    public ResponseEntity<List<TarjetaDTO>> listarTarjetas() {
        System.out.println("Lista de tarjetas");
        return new ResponseEntity<>(tarjetaService.buscarTarjetas(), HttpStatus.OK);
    }

    @PostMapping("/tarjetas")
    public ResponseEntity<TarjetaDTO> registrarTarjeta(@RequestBody TarjetaDTO tarjeta) {
        System.out.println("Tarjeta registrada");
        return new ResponseEntity<>(tarjetaService.registrarTarjeta(tarjeta), HttpStatus.CREATED);
    }
}
