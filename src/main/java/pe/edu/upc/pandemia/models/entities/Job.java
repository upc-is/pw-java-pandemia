package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Job {
	@Id
	@Column(name = "job_id", length = 10)
	private String id;
	
	@Column(name = "job_title", length = 35, nullable = false)
	private String title;
	
	@Column(name = "min_salary", columnDefinition = "NUMERIC(6)")
	private Integer minSalary;
	
	@Column(name = "max_salary", columnDefinition = "NUMERIC(6)")
	private Integer maxSalary; 
	
	private List<Employee> employees;
	
	private List<JobHistory> jobHistories;
}
