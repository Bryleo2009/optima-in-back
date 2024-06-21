package ofsystem.optima_in.Controller;

import ofsystem.optima_in.Dao.ProyectoDao;
import ofsystem.optima_in.Model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoDao service;

    @GetMapping
    public ResponseEntity<List<Proyecto>> listar() {
        return new ResponseEntity<List<Proyecto>>(service.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proyecto> registrar(Proyecto obj) {
        return new ResponseEntity<Proyecto>(service.registrar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> modificar(@PathVariable int id, Proyecto obj) {
        Proyecto cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Proyecto>(service.modificar(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable int id) {
        Proyecto cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
