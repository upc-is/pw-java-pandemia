package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "street_address", length = 40)
	private String streetAddress;
	
	@Column(name = "postal_code", length = 12)
	private String postalCode;
	
	@Column(name = "city", length = 30, nullable = false)
	private String city;
	
	@Column(name = "state_province", length = 25)
	private String stateProvince;
	
	private Country country;	// Country_id
	
	private List<Department> departments;
}
