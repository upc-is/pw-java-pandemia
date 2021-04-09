package pe.edu.upc.pandemia.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private Job job;
	
	@Column(name = "salary", columnDefinition = "DECIMAL(8,2)")
	private Float salary;
	
	@Column(name = "commission_pct", columnDefinition = "DECIMAL(2,2)")
	private Float commissionPct;
	
	private Employee manager;
	
	private Department department;
	
	private List<JobHistory> jobHistories;
	
	private List<Language> languages;
	
	// for Employee type manager
	private Department departmentManager;	
	
	private List<Employee> departmentEmployees;
}
