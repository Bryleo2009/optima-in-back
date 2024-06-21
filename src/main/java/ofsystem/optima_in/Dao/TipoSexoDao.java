package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.TipoSexo;
import ofsystem.optima_in.Model.TipoSexo;
import ofsystem.optima_in.Repo.ITipoSexoRepo;
import ofsystem.optima_in.Service.ITipoSexoService;
import ofsystem.optima_in.Service.ITipoSexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoSexoDao extends CRUDDao<TipoSexo, Integer> implements ITipoSexoService {
    @Autowired
    private ITipoSexoRepo repo;

    @Override
    protected JpaRepository<TipoSexo, Integer> getRepo() {
        return repo;
    }
}
