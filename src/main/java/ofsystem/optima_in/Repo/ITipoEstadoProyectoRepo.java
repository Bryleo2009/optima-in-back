package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.TipoEstadoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEstadoProyectoRepo extends JpaRepository<TipoEstadoProyecto, Integer> {
}
