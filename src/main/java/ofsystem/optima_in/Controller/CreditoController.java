package ofsystem.optima_in.Controller;

import ofsystem.optima_in.Dao.CreditoDao;
import ofsystem.optima_in.Model.Credito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credito")
public class CreditoController {
    @Autowired
    private CreditoDao service;

    @GetMapping
    public ResponseEntity<List<Credito>> listar() {
        return new ResponseEntity<List<Credito>>(service.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Credito> registrar(Credito obj) {
        return new ResponseEntity<Credito>(service.registrar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credito> modificar(@PathVariable int id, Credito obj) {
        Credito cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Credito>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Credito>(service.modificar(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable int id) {
        Credito cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
