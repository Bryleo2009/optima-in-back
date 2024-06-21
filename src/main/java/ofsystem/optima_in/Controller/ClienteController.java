package ofsystem.optima_in.Controller;

import ofsystem.optima_in.Dao.ClienteDao;
import ofsystem.optima_in.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteDao service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return new ResponseEntity<List<Cliente>>(service.listar().stream()
                .filter(Cliente::isEstado)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> registrar(Cliente obj) {
        return new ResponseEntity<Cliente>(service.registrar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> modificar(@PathVariable String id, Cliente obj) {
        Cliente cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(service.modificar(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable String id) {
        Cliente cliente = service.listarxID(id);
        if (cliente == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
