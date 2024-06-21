package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.Proyecto;
import ofsystem.optima_in.Repo.IProyectoRepo;
import ofsystem.optima_in.Service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProyectoDao extends CRUDDao<Proyecto, Integer> implements IProyectoService {
    @Autowired
    private IProyectoRepo repo;

    @Override
    protected JpaRepository<Proyecto, Integer> getRepo() {
        return repo;
    }
}
