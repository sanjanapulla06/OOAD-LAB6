package com.pes.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pes.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    boolean existsByVehicleNumber(String vehicleNumber);
    boolean existsBySlotNumber(int slotNumber);
}