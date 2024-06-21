package ofsystem.optima_in.Dao;

import ofsystem.optima_in.Service.ICRUDService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;


public abstract class CRUDDao<T, ID> implements ICRUDService<T,ID> {

protected abstract JpaRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public List<T> registrarMasivo(List<T> t) {
		return getRepo().saveAll(t);
	}

	@Override
	public T modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public T listarxID(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public List<T> listar() {
		return (List<T>) getRepo().findAll();
	}

	@Override
	public void eliminar(ID id) {
		Optional<T> optional = getRepo().findById(id);
		if (optional.isPresent()) {
			T obj = optional.get();
			try {
				Method setEstadoMethod = obj.getClass().getMethod("setEstado", boolean.class);
				setEstadoMethod.invoke(obj, false);
				getRepo().save(obj);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				// Manejar errores o excepciones aquí
			}
		}
	}
}
