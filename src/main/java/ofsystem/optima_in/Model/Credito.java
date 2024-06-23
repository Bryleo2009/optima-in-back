package ofsystem.optima_in.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ofsystem.optima_in.Config.Auditable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Credito")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credito extends Auditable<String> {

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

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    @Column(nullable = true, columnDefinition = "LONGBLOB")
    private byte[]  dataCuotas;

    @Transient
    private List<Map<String, String>> listCuotas;

    public Credito(int id, Cliente cliente, String nombreCredito, String descripcionCredito, TipoEstadoCredito estadoCredito, double monto, double tasaInteres, int plazo, double montoCuota, int numCuota, int diaPago, double totalPagar, double totalPagado, double totalOtros, Date fechaInicio, Proyecto proyecto, String dataCuotas){
        this.id = id;
        this.cliente = cliente;
        this.nombreCredito = nombreCredito;
        this.descripcionCredito = descripcionCredito;
        this.estadoCredito = estadoCredito;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
        this.montoCuota = montoCuota;
        this.numCuota = numCuota;
        this.diaPago = diaPago;
        this.totalPagar = totalPagar;
        this.totalPagado = totalPagado;
        this.totalOtros = totalOtros;
        this.fechaInicio = fechaInicio;
        this.proyecto = proyecto;
        this.dataCuotas = getBytes(dataCuotas);
    }

    //convierte de string a byte
    public byte[] getBytes(String data){
        return data.getBytes();
    }

    public String getString(byte[] data){
        return new String(data);
    }

    public String getDataCuotas() {
        String data = getString(dataCuotas);
        return data;
    }

    public void setDataCuotas(String dataCuotas) {
        byte[] data = getBytes(dataCuotas);
        this.dataCuotas = data;
    }
}
