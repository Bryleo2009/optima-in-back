package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.TipoSexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoSexoRepo extends JpaRepository<TipoSexo, Integer> {
}
