package pe.edu.upc.pandemia.models.repositories;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	List<Location> findByCity( String city ) throws Exception;
	List<Location> findByStateProvince( String stateProvince ) throws Exception;
}
