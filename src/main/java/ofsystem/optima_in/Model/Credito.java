package ofsystem.optima_in.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Credito")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String nombreCredito;

    @Column(nullable = false, length = 200)
    private String descripcionCredito;

    @ManyToOne
    @JoinColumn(name = "idTipoEstadoCredito")
    private TipoEstadoCredito estadoCredito;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private double tasaInteres;

    @Column(nullable = false)
    private int plazo; // en meses

    @Column(nullable = false)
    private double montoCuota;

    @Column(nullable = false)
    private int numCuota;

    @Column(nullable = false)
    private int diaPago;

    @Column(nullable = false)
    private double totalPagar;

    @Column(nullable = false)
    private double totalPagado;

    @Column(nullable = false)
    private double totalOtros;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @OneToMany
    private List<File> files = new ArrayList<>();;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}
