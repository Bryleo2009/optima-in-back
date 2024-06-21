package ofsystem.optima_in.Repo;

import ofsystem.optima_in.Model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepo extends JpaRepository<File, String> {
}
