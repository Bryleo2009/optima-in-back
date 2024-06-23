package ofsystem.optima_in.Model.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ofsystem.optima_in.Model.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralFilter {
    private List<TipoDoc> tipoDocList;
    private List<TipoEstadoCivil> tipoEstadoCivilList;
    private List<TipoEstadoCredito> tipoEstadoCreditoList;
    private List<TipoEstadoProyecto> tipoEstadoProyectoList;
    private List<TipoSexo> tipoSexoList;
}
