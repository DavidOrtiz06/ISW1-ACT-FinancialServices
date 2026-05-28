package co.edu.unbosque.ISW1_ACT_DR_DO_BACK.repositories;

import co.edu.unbosque.ISW1_ACT_DR_DO_BACK.model.entities.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
}
