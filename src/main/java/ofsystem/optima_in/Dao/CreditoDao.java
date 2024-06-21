package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.Credito;
import ofsystem.optima_in.Repo.ICreditoRepo;
import ofsystem.optima_in.Service.ICreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditoDao extends CRUDDao<Credito, Integer> implements ICreditoService {
    @Autowired
    private ICreditoRepo repo;

    @Override
    protected JpaRepository<Credito, Integer> getRepo() {
        return repo;
    }
}
