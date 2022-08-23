package one.digitalinnovation.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, String> {

}
