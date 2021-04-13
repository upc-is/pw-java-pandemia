package pe.edu.upc.pandemia.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Countries")
public class Country {
	@Id 
	@Column(name = "country_id", length = 2, nullable = false)
	private String id;
	
	@Column(name = "country_name", length = 40)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)	// Foreing Key
	private Region region; // Region_Id
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Location> locations;
}
