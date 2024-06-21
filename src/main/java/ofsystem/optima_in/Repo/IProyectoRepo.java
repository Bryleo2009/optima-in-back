package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepo extends JpaRepository<Proyecto, Integer> {
}
