package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.TipoDoc;
import ofsystem.optima_in.Repo.ITipoDocRepo;
import ofsystem.optima_in.Service.ITipoDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDocDao extends CRUDDao<TipoDoc, Integer> implements ITipoDocService {
    @Autowired
    private ITipoDocRepo repo;

    @Override
    protected JpaRepository<TipoDoc, Integer> getRepo() {
        return repo;
    }
}
