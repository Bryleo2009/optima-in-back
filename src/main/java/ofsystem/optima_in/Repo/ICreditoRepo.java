package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditoRepo extends JpaRepository<Credito, Integer> {
}
