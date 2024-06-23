package ofsystem.optima_in.Config;

import ofsystem.optima_in.Dao.*;
import ofsystem.optima_in.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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

//        Cliente cliente = new Cliente();
//        cliente.setNombresCli("Juan");
//        cliente.setApellidosCli("Perez");
//        cliente.setTipoDoc(tipoDocService.listarxID(1));
//        cliente.setNumDoc("12345678");
//        cliente.setTipoSexo(tipoSexoService.listarxID(1));
//        cliente.setTipoEstadoCivil(tipoEstadoCivilService.listarxID(1));
//        cliente.setDireccionCli("Jr. Los Pinos 123");
//        cliente.setTelefonoCli("987654321");
//        cliente.setEmailCli("prueba@hotmail.com");
//        cliente.setFechaNacCli(new Date());
//        cliente.setEstado(true);
//        clienteService.registrar(cliente);

        //crea 10 clioentes
        List< Cliente > clientes = new ArrayList<>();
        clientes.addAll(Arrays.asList(
                new Cliente("Juan", "Perez", tipoDocService.listarxID(1), "12345678", tipoSexoService.listarxID(1), tipoEstadoCivilService.listarxID(1), "Jr. Los Pinos 123", "987654321", "juan.perez@hotmail.com", new Date()),
                new Cliente("Maria", "Lopez", tipoDocService.listarxID(1), "87654321", tipoSexoService.listarxID(2), tipoEstadoCivilService.listarxID(2), "Av. Primavera 456", "999888777", "maria.lopez@gmail.com", new Date()),
                new Cliente("Pedro", "Garcia", tipoDocService.listarxID(1), "13579246", tipoSexoService.listarxID(1), tipoEstadoCivilService.listarxID(3), "Calle Sol 789", "123456789", "pedro.garcia@yahoo.com", new Date()),
                new Cliente("Luisa", "Martinez", tipoDocService.listarxID(1), "98765432", tipoSexoService.listarxID(2), tipoEstadoCivilService.listarxID(1), "Pasaje Luna 246", "555444333", "luisa.martinez@hotmail.com", new Date()),
                new Cliente("Carlos", "Rodriguez", tipoDocService.listarxID(1), "24681357", tipoSexoService.listarxID(1), tipoEstadoCivilService.listarxID(2), "Ovalo Central 789", "777666555", "carlos.rodriguez@gmail.com", new Date()),
                new Cliente("Laura", "Sanchez", tipoDocService.listarxID(1), "65432187", tipoSexoService.listarxID(2), tipoEstadoCivilService.listarxID(3), "Plaza Mayor 159", "222333444", "laura.sanchez@yahoo.com", new Date()),
                new Cliente("Diego", "Ramirez", tipoDocService.listarxID(1), "36985214", tipoSexoService.listarxID(1), tipoEstadoCivilService.listarxID(1), "Avenida Central 357", "666777888", "diego.ramirez@hotmail.com", new Date()),
                new Cliente("Ana", "Gonzalez", tipoDocService.listarxID(1), "74125896", tipoSexoService.listarxID(2), tipoEstadoCivilService.listarxID(2), "Callejon de los Suspiros 852", "333222111", "ana.gonzalez@gmail.com", new Date()),
                new Cliente("Jorge", "Hernandez", tipoDocService.listarxID(1), "58246173", tipoSexoService.listarxID(1), tipoEstadoCivilService.listarxID(3), "Paseo de la Reforma 741", "999000111", "jorge.hernandez@yahoo.com", new Date()),
                new Cliente("Isabel", "Torres", tipoDocService.listarxID(1), "96385274", tipoSexoService.listarxID(2), tipoEstadoCivilService.listarxID(1), "Callejon del Beso 369", "888999000", "isabel.torres@hotmail.com", new Date())));
        clienteService.registrarMasivo(clientes);

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

        List< Proyecto > proyectos = new ArrayList<>();
        //creame 5 proyectos
        proyectos.addAll(Arrays.asList(
                new Proyecto(1, "Proyecto 1", "Proyecto 1", tipoEstadoProyectoService.listarxID(1), new Date()),
                new Proyecto(2, "Proyecto 2", "Proyecto 2", tipoEstadoProyectoService.listarxID(1), new Date()),
                new Proyecto(3, "Proyecto 3", "Proyecto 3", tipoEstadoProyectoService.listarxID(1), new Date()),
                new Proyecto(4, "Proyecto 4", "Proyecto 4", tipoEstadoProyectoService.listarxID(1), new Date()),
                new Proyecto(5, "Proyecto 5", "Proyecto 5", tipoEstadoProyectoService.listarxID(1), new Date())
        ));
        proyectoService.registrarMasivo(proyectos);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List< Credito > creditos = new ArrayList<>();
//        creditos.addAll(Arrays.asList(
//                new Credito(1, clienteService.listarxID("12345678"), "Credito 1", "Credito 1", tipoEstadoCreditoService.listarxID(1), 1000, 20, 12, 100, 1, 1, 1200, 0, 0, formatter.parse("02/05/2024"),proyectoService.listarxID(1),"id:1&fechaPago:01/06/2024$estado:0$publicId:creditos/gseccv34yh9itxwhk8u5|id:2&fechaPago:01/07/2024$estado:1|id:3&fechaPago:01/08/2024$estado:1|id:4&fechaPago:01/09/2024$estado:1|id:5&fechaPago:01/10/2024$estado:1|id:6&fechaPago:01/11/2024$estado:1|id:7&fechaPago:01/12/2024$estado:1|id:8&fechaPago:01/01/2025$estado:1|id:9&fechaPago:01/02/2025$estado:1|id:10&fechaPago:01/03/2025$estado:1|id:11&fechaPago:01/04/2025$estado:1|id:12&fechaPago:01/05/2025$estado:1"),
//                new Credito(2, clienteService.listarxID("12345678"), "Credito 2", "Credito 2", tipoEstadoCreditoService.listarxID(1), 2000, 20, 6, 366.7, 1, 1, 2200, 0, 0, formatter.parse("02/06/2024"),proyectoService.listarxID(1),"id:1&fechaPago:01/07/2024$estado:1|id:2&fechaPago:01/08/2024$estado:1|id:3&fechaPago:01/09/2024$estado:1|id:4&fechaPago:01/10/2024$estado:1|id:5&fechaPago:01/11/2024$estado:1|id:6&fechaPago:01/12/2024$estado:1"),
//                new Credito(3, clienteService.listarxID("12345678"), "Credito 3", "Credito 3", tipoEstadoCreditoService.listarxID(1), 3500, 20, 6, 641.7, 1, 1, 3850, 0, 0, formatter.parse("02/04/2024"),proyectoService.listarxID(2),"id:1&fechaPago:01/05/2024$estado:1|id:2&fechaPago:01/06/2024$estado:1|id:3&fechaPago:01/07/2024$estado:1|id:4&fechaPago:01/08/2024$estado:1|id:5&fechaPago:01/09/2024$estado:1|id:6&fechaPago:01/10/2024$estado:1"),
//                new Credito(4, clienteService.listarxID("71850926"), "Credito 4", "Credito 4", tipoEstadoCreditoService.listarxID(1), 3500, 20, 6, 641.7, 1, 1, 3850, 0, 0, formatter.parse("08/04/2024"),proyectoService.listarxID(2),"id:1&fechaPago:01/05/2024$estado:1|id:2&fechaPago:01/06/2024$estado:1|id:3&fechaPago:01/07/2024$estado:1|id:4&fechaPago:01/08/2024$estado:1|id:5&fechaPago:01/09/2024$estado:1|id:6&fechaPago:01/10/2024$estado:1")
//        ));

        creditos.addAll(Arrays.asList(
                new Credito(1, clienteService.listarxID("12345678"), "Crédito 1", "Descripción Crédito 1", tipoEstadoCreditoService.listarxID(1), 1500, 15, 5, 300, 1, 1, 1800, 0, 0, formatter.parse("15/04/2024"), proyectoService.listarxID(1), "id:1&fechaPago:15/05/2024&estado:0&publicId:creditos/gseccv34yh9itxwhk8u5|id:2&fechaPago:15/06/2024&estado:1|id:3&fechaPago:15/07/2024&estado:1|id:4&fechaPago:15/08/2024&estado:1|id:5&fechaPago:15/09/2024&estado:1"),
                new Credito(2, clienteService.listarxID("98765432"), "Crédito 2", "Descripción Crédito 2", tipoEstadoCreditoService.listarxID(1), 2500, 25, 7, 357.1, 2, 2, 3000, 0, 0, formatter.parse("20/04/2024"), proyectoService.listarxID(2), "id:1&fechaPago:20/05/2024&estado:1|id:2&fechaPago:20/06/2024&estado:1|id:3&fechaPago:20/07/2024&estado:1|id:4&fechaPago:20/08/2024&estado:1|id:5&fechaPago:20/09/2024&estado:1|id:6&fechaPago:20/10/2024&estado:1|id:7&fechaPago:20/11/2024&estado:1"),
                new Credito(3, clienteService.listarxID("65432187"), "Crédito 3", "Descripción Crédito 3", tipoEstadoCreditoService.listarxID(1), 1800, 18, 6, 300, 3, 3, 2000, 0, 0, formatter.parse("25/04/2024"), proyectoService.listarxID(3), "id:1&fechaPago:25/05/2024&estado:1|id:2&fechaPago:25/06/2024&estado:1|id:3&fechaPago:25/07/2024&estado:1|id:4&fechaPago:25/08/2024&estado:1|id:5&fechaPago:25/09/2024&estado:1|id:6&fechaPago:25/10/2024&estado:1"),
                new Credito(4, clienteService.listarxID("74125896"), "Crédito 4", "Descripción Crédito 4", tipoEstadoCreditoService.listarxID(1), 3000, 30, 8, 375, 4, 4, 3500, 0, 0, formatter.parse("10/04/2024"), proyectoService.listarxID(4), "id:1&fechaPago:10/05/2024&estado:1|id:2&fechaPago:10/06/2024&estado:1|id:3&fechaPago:10/07/2024&estado:1|id:4&fechaPago:10/08/2024&estado:1|id:5&fechaPago:10/09/2024&estado:1|id:6&fechaPago:10/10/2024&estado:1|id:7&fechaPago:10/11/2024&estado:1|id:8&fechaPago:10/12/2024&estado:1"),
                new Credito(5, clienteService.listarxID("36985214"), "Crédito 5", "Descripción Crédito 5", tipoEstadoCreditoService.listarxID(1), 2000, 20, 6, 333.3, 5, 5, 2300, 0, 0, formatter.parse("15/04/2024"), proyectoService.listarxID(5), "id:1&fechaPago:15/05/2024&estado:1|id:2&fechaPago:15/06/2024&estado:1|id:3&fechaPago:15/07/2024&estado:1|id:4&fechaPago:15/08/2024&estado:1|id:5&fechaPago:15/09/2024&estado:1|id:6&fechaPago:15/10/2024&estado:1"),
                new Credito(6, clienteService.listarxID("12345678"), "Crédito 6", "Descripción Crédito 6", tipoEstadoCreditoService.listarxID(1), 2500, 25, 7, 357.1, 6, 5, 2800, 0, 0, formatter.parse("20/04/2024"), proyectoService.listarxID(5), "id:1&fechaPago:20/05/2024&estado:1|id:2&fechaPago:20/06/2024&estado:1|id:3&fechaPago:20/07/2024&estado:1|id:4&fechaPago:20/08/2024&estado:1|id:5&fechaPago:20/09/2024&estado:1|id:6&fechaPago:20/10/2024&estado:1|id:7&fechaPago:20/11/2024&estado:1"),
                new Credito(7, clienteService.listarxID("98765432"), "Crédito 7", "Descripción Crédito 7", tipoEstadoCreditoService.listarxID(1), 1800, 18, 6, 300, 7, 4, 2000, 0, 0, formatter.parse("05/04/2024"), proyectoService.listarxID(4), "id:1&fechaPago:05/05/2024&estado:1|id:2&fechaPago:05/06/2024&estado:1|id:3&fechaPago:05/07/2024&estado:1|id:4&fechaPago:05/08/2024&estado:1|id:5&fechaPago:05/09/2024&estado:1|id:6&fechaPago:05/10/2024&estado:1"),
                new Credito(8, clienteService.listarxID("65432187"), "Crédito 8", "Descripción Crédito 8", tipoEstadoCreditoService.listarxID(1), 3000, 30, 8, 375, 8, 3, 3500, 0, 0, formatter.parse("10/04/2024"), proyectoService.listarxID(2), "id:1&fechaPago:10/05/2024&estado:1|id:2&fechaPago:10/06/2024&estado:1|id:3&fechaPago:10/07/2024&estado:1|id:4&fechaPago:10/08/2024&estado:1|id:5&fechaPago:10/09/2024&estado:1|id:6&fechaPago:10/10/2024&estado:1|id:7&fechaPago:10/11/2024&estado:1|id:8&fechaPago:10/12/2024&estado:1"),
                new Credito(9, clienteService.listarxID("74125896"), "Crédito 9", "Descripción Crédito 9", tipoEstadoCreditoService.listarxID(1), 2000, 20, 6, 333.3, 9, 2, 2300, 0, 0, formatter.parse("01/04/2024"), proyectoService.listarxID(3), "id:1&fechaPago:01/05/2024&estado:1|id:2&fechaPago:01/06/2024&estado:1|id:3&fechaPago:01/07/2024&estado:1|id:4&fechaPago:01/08/2024&estado:1|id:5&fechaPago:01/09/2024&estado:1|id:6&fechaPago:01/10/2024&estado:1"),
                new Credito(10, clienteService.listarxID("36985214"), "Crédito 10", "Descripción Crédito 10", tipoEstadoCreditoService.listarxID(1), 2500, 25, 7, 357.1, 10, 1, 2800, 0, 0, formatter.parse("05/04/2024"), proyectoService.listarxID(1), "id:1&fechaPago:05/05/2024&estado:1|id:2&fechaPago:05/06/2024&estado:1|id:3&fechaPago:05/07/2024&estado:1|id:4&fechaPago:05/08/2024&estado:1|id:5&fechaPago:05/09/2024&estado:1|id:6&fechaPago:05/10/2024&estado:1")
        ));
        creditoService.registrarMasivo(creditos);
    }
}
