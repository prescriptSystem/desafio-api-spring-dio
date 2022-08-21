package one.digitalinnovation.parking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ParkingDTO {
	
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private String entryDate;
	private String exitDate;
	private Double bill;

}
