package ofsystem.optima_in.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ofsystem.optima_in.Config.Auditable;

import java.util.Date;

@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Auditable<String> {
    @Id
    private String numDoc;

    @Column(nullable = false, length = 200)
    private String nombresCli;

    @Column(nullable = false, length = 200)
    private String apellidosCli;

    @Column(nullable = false, length = 500)
    private String direccionCli;

    @Column(nullable = false, length = 20)
    private String telefonoCli;

    @Column(nullable = false, length = 200)
    @Email
    private String emailCli;

    @ManyToOne
    @JoinColumn(name = "idTipoSexo")
    private TipoSexo tipoSexo;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacCli;

    @ManyToOne
    @JoinColumn(name = "idTipoEstadoCivil")
    private TipoEstadoCivil tipoEstadoCivil;

    @ManyToOne
    @JoinColumn(name = "idTipoDoc")
    private TipoDoc tipoDoc;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private boolean estado;

    public Cliente(String nombresCli, String apellidosCli, TipoDoc tipoDoc, String numDoc, TipoSexo tipoSexo, TipoEstadoCivil tipoEstadoCivil, String direccionCli, String telefonoCli, String emailCli, Date fechaNacCli) {
    this.nombresCli = nombresCli;
    this.apellidosCli = apellidosCli;
    this.tipoDoc = tipoDoc;
    this.numDoc = numDoc;
    this.tipoSexo = tipoSexo;
    this.tipoEstadoCivil = tipoEstadoCivil;
    this.direccionCli = direccionCli;
    this.telefonoCli = telefonoCli;
    this.emailCli = emailCli;
    this.fechaNacCli = fechaNacCli;
    this.estado = true; // Assuming a new client is always active
}
}
