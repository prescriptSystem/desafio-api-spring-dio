package one.digitalinnovation.parking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Parking {

	public Parking(String id, String license, String state, String model, String color) {
		this.id = id;
		this.license = license;
		this.state = license;
		this.model = model;
		this.color = color;
	}
	
	public Parking() {
		
	}
	
	@Id
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;
	
}
