package ofsystem.optima_in.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TipoEstadoProyecto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoEstadoProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String descripcion;
}
