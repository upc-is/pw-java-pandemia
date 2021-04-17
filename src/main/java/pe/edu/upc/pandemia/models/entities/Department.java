package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "departmentManager", fetch = FetchType.EAGER)
	private Employee manager;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = true)
	private Location location;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	// Desbloquear cuando se crea el Primary Key Compuesto
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistories;
}
