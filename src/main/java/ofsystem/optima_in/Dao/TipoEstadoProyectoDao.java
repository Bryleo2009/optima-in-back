package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.TipoEstadoProyecto;
import ofsystem.optima_in.Repo.ITipoEstadoProyectoRepo;
import ofsystem.optima_in.Service.ITipoEstadoProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEstadoProyectoDao extends CRUDDao<TipoEstadoProyecto, Integer> implements ITipoEstadoProyectoService {
    @Autowired
    private ITipoEstadoProyectoRepo repo;

    @Override
    protected JpaRepository<TipoEstadoProyecto, Integer> getRepo() {
        return repo;
    }
}
