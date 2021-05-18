package pe.edu.upc.pandemia.models.repositories;

import java.util.List;
import java.util.Optional;

// Interface base
// T: Entity, ID: Tipo de Dato del ID
public interface JpaRepository<T, ID> {
	T save(T entity) throws Exception;
	T update(T entity) throws Exception;	
	Optional<T> findById(ID id) throws Exception;
	List<T> findAll() throws Exception;
	void deleteById(ID id) throws Exception;
}
