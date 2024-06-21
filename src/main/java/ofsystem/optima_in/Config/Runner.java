package ofsystem.optima_in.Config;

import ofsystem.optima_in.Dao.*;
import ofsystem.optima_in.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private TipoDocDao tipoDocService;
    @Autowired
    private TipoSexoDao tipoSexoService;
    @Autowired
    private TipoEstadoCivilDao tipoEstadoCivilService;
    @Autowired
    private ClienteDao clienteService;
    @Autowired
    private TipoEstadoCreditoDao tipoEstadoCreditoService;
    @Autowired
    private TipoEstadoProyectoDao tipoEstadoProyectoService;
    @Autowired
    private CreditoDao creditoService;
    @Autowired
    private ProyectoDao proyectoService;


    @Override
    public void run(String... args) throws Exception {

        List<TipoDoc> tipoDocs = new ArrayList<>();
        tipoDocs.addAll(Arrays.asList(
                new TipoDoc(1, "DNI"),
                new TipoDoc(2, "CE")));
        tipoDocService.registrarMasivo(tipoDocs);

        List< TipoEstadoCivil > tipoEstadoCivils = new ArrayList<>();
        tipoEstadoCivils.addAll(Arrays.asList(
                new TipoEstadoCivil(1, "Soltero"),
                new TipoEstadoCivil(2, "Casado"),
                new TipoEstadoCivil(3, "Divorciado"),
                new TipoEstadoCivil(4, "Viudo")));
        tipoEstadoCivilService.registrarMasivo(tipoEstadoCivils);

        List< TipoSexo > tipoSexos = new ArrayList<>();
        tipoSexos.addAll(Arrays.asList(
                new TipoSexo(1, "Masculino"),
                new TipoSexo(2, "Femenino")));
        tipoSexoService.registrarMasivo(tipoSexos);

        Cliente cliente = new Cliente();
        cliente.setNombresCli("Juan");
        cliente.setApellidosCli("Perez");
        cliente.setTipoDoc(tipoDocService.listarxID(1));
        cliente.setNumDoc("12345678");
        cliente.setTipoSexo(tipoSexoService.listarxID(1));
        cliente.setTipoEstadoCivil(tipoEstadoCivilService.listarxID(1));
        cliente.setDireccionCli("Jr. Los Pinos 123");
        cliente.setTelefonoCli("987654321");
        cliente.setEmailCli("prueba@hotmail.com");
        cliente.setFechaNacCli(new Date());
        cliente.setEstado(true);
        clienteService.registrar(cliente);

        List< TipoEstadoCredito > tipoEstadoCreditos = new ArrayList<>();
        tipoEstadoCreditos.addAll(Arrays.asList(
                new TipoEstadoCredito(1, "Aperturado"),
                new TipoEstadoCredito(2, "Culminado")));
        tipoEstadoCreditoService.registrarMasivo(tipoEstadoCreditos);

        List< TipoEstadoProyecto > tipoEstadoProyectos = new ArrayList<>();
        tipoEstadoProyectos.addAll(Arrays.asList(
                new TipoEstadoProyecto(1, "En Proceso"),
                new TipoEstadoProyecto(2, "Culminado")));
        tipoEstadoProyectoService.registrarMasivo(tipoEstadoProyectos);

        Credito credito = new Credito();
        credito.setCliente(clienteService.listarxID("12345678"));
        credito.setNombreCredito("Credito 1");
        credito.setDescripcionCredito("Credito 1");
        credito.setEstadoCredito(tipoEstadoCreditoService.listarxID(1));
        credito.setMonto(1000);
        credito.setTasaInteres(0.1);
        credito.setPlazo(12);
        credito.setMontoCuota(100);
        credito.setNumCuota(1);
        credito.setDiaPago(15);
        credito.setTotalPagar(1200);
        credito.setTotalPagado(0);
        credito.setTotalOtros(0);
        credito.setFechaInicio(new Date());
        creditoService.registrar(credito);

        Proyecto proyecto = new Proyecto();
        proyecto.setNombreProyecto("Proyecto 1");
        proyecto.setDescripcionProyecto("Proyecto 1");
        proyecto.setEstadoProyecto(tipoEstadoProyectoService.listarxID(1));
        proyecto.setFechaInicio(new Date());
        proyecto.setCreditos(Arrays.asList(creditoService.listarxID(1)));
        proyectoService.registrar(proyecto);

    }
}
