package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", columnDefinition = "NUMERIC(4)")	// PostgreSQL
	private Integer id;
	
	@Column(name = "department_name", length = 30)
	private String name;
	
	private Employee manager;
	
	private Location location;
	
	private List<Employee> employees;
	
	private List<JobHistory> jobHistories;
}
