package one.digitalinnovation.parking.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.repository.ParkingRepository;

@Service
public class ParkingService {
	
	@Autowired
	ParkingRepository parkingRepository;
	
	@Transactional
	public List<Parking> findAll()
	{
		return parkingRepository.findAll();
		
	}
	
	private static String getUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Transactional
	public Parking findById(String id) {
		
		
		return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
	}

	@Transactional
	public Parking create(Parking parkingCreate) {
		String uuid = getUUID();
		parkingCreate.setId(uuid);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingRepository.save(parkingCreate);
		return parkingCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		parkingRepository.deleteById(id);
		
	}

	@Transactional
	public Parking update(String id, Parking parkingCreate) {
		var parking = findById(id);
		parking.setColor(parkingCreate.getColor());
		parking.setState(parkingCreate.getState());
		parking.setModel(parkingCreate.getModel());
		parking.setLicense(parkingCreate.getLicense());
		parkingRepository.save(parking);
		return parking;
	}
	
	@Transactional
	public Parking checkOut(String id)
	{
		Parking parking =  findById(id);
		parking.setEntryDate(LocalDateTime.now());
		parking.setBill(ParkingCheckOut.getBill(parking));
		
		return parkingRepository.save(parking);
	}
	
	

}
