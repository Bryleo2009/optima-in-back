package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.Cliente;
import ofsystem.optima_in.Repo.IClienteRepo;
import ofsystem.optima_in.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteDao  extends CRUDDao<Cliente, String> implements IClienteService {
    @Autowired
    private IClienteRepo repo;

    @Override
    protected JpaRepository<Cliente, String> getRepo() {
        return repo;
    }
}
