package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.TipoEstadoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEstadoCreditoRepo extends JpaRepository<TipoEstadoCredito, Integer> {
}
