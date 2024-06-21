package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, String> {
}
