package ofsystem.optima_in.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ofsystem.optima_in.Config.Auditable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Proyecto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String nombreProyecto;

    @Column(nullable = false, length = 200)
    private String descripcionProyecto;

    @ManyToOne
    @JoinColumn(name = "idTipoEstadoProyecto")
    private TipoEstadoProyecto estadoProyecto;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;


    public Proyecto(int id, String nombreProyecto, String descripcionProyecto, TipoEstadoProyecto estadoProyecto, Date fechaInicio) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.estadoProyecto = estadoProyecto;
        this.fechaInicio = fechaInicio;
    }

}
