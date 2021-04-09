package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Countries")
public class Country {
	@Id 
	@Column(name = "country_id", length = 2, nullable = false)
	private String id;
	
	@Column(name = "country_name", length = 40)
	private String name;
	
	private Region region; // Region_Id
	
	private List<Location> locations;
}
