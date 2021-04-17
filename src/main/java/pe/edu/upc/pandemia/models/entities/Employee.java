package pe.edu.upc.pandemia.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employees")
public class Employee {	// Upper Camel case
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@Column(name = "first_name", length = 20)
	private String firstName; // Lower camel case
	
	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 25, nullable = false)
	private String email;
	
	@Column(name = "phone_number", length = 20, nullable = false)
	private String phoneNumber;
	
	@Column(name = "hire_date")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;
	
	@Column(name = "salary", columnDefinition = "DECIMAL(8,2)")
	private Float salary;
	
	@Column(name = "commission_pct", columnDefinition = "DECIMAL(2,2)")
	private Float commissionPct;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;		// Relation Ship - consigo mismo
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = true)
	private Department department;
	
	@OneToMany(mappedBy = "employee")
	private List<JobHistory> jobHistories;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employees_languages", 
			joinColumns = { @JoinColumn(referencedColumnName = "employee_id", name = "employee_id") },
			inverseJoinColumns = {@JoinColumn(referencedColumnName = "language_id", name = "language_id")})
	private List<Language> languages;
	
	// for Employee job(rol) Manager
	@OneToOne
	@JoinColumn(name = "manager_id", nullable = true)
	private Department departmentManager;	
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
	private List<Employee> departmentEmployees; 	// Relation Ship - consigo mismo
	
	@OneToOne(mappedBy = "employee")
	private User user;
}
