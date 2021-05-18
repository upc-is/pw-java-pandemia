package pe.edu.upc.pandemia.models.repositories;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
