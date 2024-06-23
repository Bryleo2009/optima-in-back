package ofsystem.optima_in.Controller;

import ofsystem.optima_in.Dao.*;
import ofsystem.optima_in.Model.Cliente;
import ofsystem.optima_in.Model.Filter.GeneralFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {
    @Autowired
    private TipoEstadoProyectoDao tipoEstadoProyectoDao;
    @Autowired
    private TipoEstadoCreditoDao tipoEstadoCreditoDao;
    @Autowired
    private TipoEstadoCivilDao tipoEstadoCivilDao;
    @Autowired
    private TipoSexoDao tipoSexoDao;
    @Autowired
    private TipoDocDao tipoDocDao;

    @GetMapping
    public ResponseEntity<GeneralFilter> listar() {
        GeneralFilter generalFilter = new GeneralFilter();
        generalFilter.setTipoDocList(tipoDocDao.listar());
        generalFilter.setTipoEstadoProyectoList(tipoEstadoProyectoDao.listar());
        generalFilter.setTipoEstadoCreditoList(tipoEstadoCreditoDao.listar());
        generalFilter.setTipoEstadoCivilList(tipoEstadoCivilDao.listar());
        generalFilter.setTipoSexoList(tipoSexoDao.listar());

        return new ResponseEntity<GeneralFilter>(generalFilter, HttpStatus.OK);
    }
}
