package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.TipoEstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEstadoCivilRepo extends JpaRepository<TipoEstadoCivil, Integer> {
}
