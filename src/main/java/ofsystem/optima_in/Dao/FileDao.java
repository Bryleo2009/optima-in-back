package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Model.File;
import ofsystem.optima_in.Repo.IFileRepo;
import ofsystem.optima_in.Service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FileDao extends CRUDDao<File, String> implements IFileService {
    @Autowired
    private IFileRepo repo;

    @Override
    protected JpaRepository<File, String> getRepo() {
        return repo;
    }
}
