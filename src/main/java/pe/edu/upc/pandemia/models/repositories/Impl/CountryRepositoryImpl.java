package pe.edu.upc.pandemia.models.repositories.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.pandemia.models.entities.Country;
import pe.edu.upc.pandemia.models.repositories.CountryRepository;

public class CountryRepositoryImpl implements CountryRepository, Serializable  {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;

	@Override
	public Country save(Country entity) throws Exception {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Country update(Country entity) throws Exception {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public Optional<Country> findById(String id) throws Exception {
		
		// Creando un optional vacio
		Optional<Country> optional = Optional.empty();
		// Buscando un country por Id
		Country country = entityManager.find(Country.class, id);		
		// Si country contiene al resultado de la busqueda, agrego a optional 
		if(country != null) {
			optional = Optional.of( country );
		}		
		return optional;
	}

	@Override
	public List<Country> findAll() throws Exception {
		// Creando la Lista para retornar
		List<Country> countries = new ArrayList<Country>();
		// Crear la Sentencia JPQL
		String jpql = "SELECT country FROM Country country";
		// Ejecutar el JPQL
		TypedQuery<Country> typedQuery = entityManager.createQuery(jpql, Country.class);
		// Obtener el resultado del Query
		countries = typedQuery.getResultList();		
		
		return countries;
	}
	
	@Override
	public void deleteById(String id) throws Exception {
		
		// Utilizar el findById para obtener el objeto para eliminarlo
		Optional<Country> optional = findById(id);
		// Verificar que el optinal contiene el objeto
		if( optional.isPresent() ) {
			// Eliminar el Objeto que se encuentra en Optional
			entityManager.remove( optional.get() );
		}
		
	}

}
