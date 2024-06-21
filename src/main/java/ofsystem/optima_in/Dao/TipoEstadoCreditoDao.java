package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.TipoEstadoCredito;
import ofsystem.optima_in.Repo.ITipoEstadoCreditoRepo;
import ofsystem.optima_in.Service.ITipoEstadoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEstadoCreditoDao extends CRUDDao<TipoEstadoCredito, Integer> implements ITipoEstadoCreditoService {
    @Autowired
    private ITipoEstadoCreditoRepo repo;

    @Override
    protected JpaRepository<TipoEstadoCredito, Integer> getRepo() {
        return repo;
    }
}
