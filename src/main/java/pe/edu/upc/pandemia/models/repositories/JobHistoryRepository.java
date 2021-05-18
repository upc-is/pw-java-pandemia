package pe.edu.upc.pandemia.models.repositories;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Employee;
import pe.edu.upc.pandemia.models.entities.JobHistory;
import pe.edu.upc.pandemia.models.entities.JobHistoryId;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
	List<JobHistory> findByEmployee(Employee employee) throws Exception;
}
