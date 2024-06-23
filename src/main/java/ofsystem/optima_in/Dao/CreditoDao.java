package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Config.Exception.ModeloNotFoundException;
import ofsystem.optima_in.Model.Credito;
import ofsystem.optima_in.Repo.ICreditoRepo;
import ofsystem.optima_in.Service.ICreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CreditoDao extends CRUDDao<Credito, Integer> implements ICreditoService {
    @Autowired
    private ICreditoRepo repo;

    @Override
    protected JpaRepository<Credito, Integer> getRepo() {
        return repo;
    }

    public List<Credito> listar(String search, Date fechIni, Date fechFin) {

        List<Credito> listaFiltrada = repo.findAll().stream().filter(obj -> {
            boolean matchesSearch = Objects.isNull(search) || search.trim().isEmpty() ||
                    obj.getCliente().getNombresCli().toLowerCase().contains(search.toLowerCase()) ||
                    obj.getCliente().getApellidosCli().toLowerCase().contains(search.toLowerCase()) ||
                    obj.getCliente().getNumDoc().toLowerCase().contains(search.toLowerCase()) ||
                    obj.getProyecto().getNombreProyecto().toLowerCase().contains(search.toLowerCase());

            boolean matchesDateRange = true;
            if(Objects.isNull(fechIni) && Objects.nonNull(fechFin) || Objects.nonNull(fechIni) && Objects.isNull(fechFin)){
                throw new ModeloNotFoundException("Debe ingresar ambas fechas para realizar la busqueda por rango");
            } else if (fechIni != null && fechFin != null) {
                matchesDateRange = !obj.getFechaInicio().before(fechIni) && !obj.getFechaInicio().after(fechFin);
            }

            return matchesSearch && matchesDateRange;
        }).collect(Collectors.toList());

        List<Credito> lista = listaFiltrada.stream().map(obj -> {
            List<Map<String, String>> dataCuotasList = Objects.isNull(obj.getDataCuotas()) || obj.getDataCuotas().trim().isEmpty() ? null :
                    Arrays.stream(obj.getDataCuotas().trim().split("\\|"))
                            .map(s -> Arrays.stream(s.split("&"))
                                    .flatMap(t -> Arrays.stream(t.split("\\$")))
                                    .map(u -> u.split(":"))
                                    .collect(Collectors.toMap(u -> u[0], u -> u[1])))
                            .collect(Collectors.toList());
            obj.setListCuotas(dataCuotasList);
            return obj;
        }).collect(Collectors.toList());
        return lista;
    }

    public void cambioEstado(int idCredito, int idCuota, String publicId){
        Credito credito = repo.findById(idCredito).orElse(null);
        if (credito == null) {
            throw new ModeloNotFoundException("El credito no existe");
        }
        List<Map<String, String>> dataCuotasList = Objects.isNull(credito.getDataCuotas()) || credito.getDataCuotas().trim().isEmpty() ? null :
                Arrays.stream(credito.getDataCuotas().trim().split("\\|"))
                        .map(s -> Arrays.stream(s.split("&"))
                                .flatMap(t -> Arrays.stream(t.split("\\$")))
                                .map(u -> u.split(":"))
                                .collect(Collectors.toMap(u -> u[0], u -> u[1])))
                        .collect(Collectors.toList());
        if (dataCuotasList == null) {
            throw new ModeloNotFoundException("El credito no tiene cuotas");
        }
        Map<String, String> cuota = dataCuotasList.stream().filter(obj -> obj.get("id").equals(String.valueOf(idCuota))).findFirst().orElse(null);
        if (cuota == null) {
            throw new ModeloNotFoundException("La cuota no existe");
        }

        cuota.put("estado", "0");
        cuota.put("publicId", publicId);
        cuota.put("fechaPago", dataCuotasList.stream().filter(obj -> obj.get("id").equals(String.valueOf(idCuota))).findFirst().get().get("fechaPago"));
        credito.setDataCuotas(dataCuotasList.stream().map(obj -> obj.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining("&"))).collect(Collectors.joining("|")));
        repo.save(credito);
    }
}
