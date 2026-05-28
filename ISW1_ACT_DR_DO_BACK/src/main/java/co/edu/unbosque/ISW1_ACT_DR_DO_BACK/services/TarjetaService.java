package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.services;

import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.dtos.TarjetaDTO;
import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.entities.Tarjeta;
import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.repositories.TarjetaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private ModelMapper modelMapper = new ModelMapper();


    public TarjetaService(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    public List<TarjetaDTO> buscarTarjetas() {
        List<TarjetaDTO> listaTarjetas = new ArrayList<>();
        List<Tarjeta> tarjetasBD = tarjetaRepository.findAll();
        for (Tarjeta tarjeta : tarjetasBD) {
            listaTarjetas.add(modelMapper.map(tarjeta, TarjetaDTO.class));
        }
        return listaTarjetas;
    }

    public TarjetaDTO registrarTarjeta(TarjetaDTO tarjeta) {
        return modelMapper.map(tarjetaRepository.save(modelMapper.map(tarjeta, Tarjeta.class)), TarjetaDTO.class);
    }

    public TarjetaService actualizarTarjeta(String id, Integer cupoTarjeta) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).get();
        tarjeta.setCupoTotal(cupoTarjeta);
        return modelMapper.map(tarjetaRepository.save(tarjeta), TarjetaService.class);
    }
}
