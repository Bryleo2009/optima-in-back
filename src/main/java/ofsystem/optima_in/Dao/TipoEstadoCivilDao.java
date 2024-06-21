package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.TipoEstadoCivil;
import ofsystem.optima_in.Repo.ITipoEstadoCivilRepo;
import ofsystem.optima_in.Service.ITipoEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEstadoCivilDao extends CRUDDao<TipoEstadoCivil, Integer> implements ITipoEstadoCivilService {
    @Autowired
    private ITipoEstadoCivilRepo repo;

    @Override
    protected JpaRepository<TipoEstadoCivil, Integer> getRepo() {
        return repo;
    }
}
