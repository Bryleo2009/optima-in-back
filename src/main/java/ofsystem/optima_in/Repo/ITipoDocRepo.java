package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocRepo extends JpaRepository<TipoDoc, Integer> {
}
