package one.digitalinnovation.parking.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private LocalDateTime entryDate;
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private LocalDateTime exitDate;
	private Double bill;

}
