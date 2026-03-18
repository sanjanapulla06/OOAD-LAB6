package com.pes.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.pes.parking.model.Parking;
import com.pes.parking.repository.ParkingRepository;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository repo;

    public void saveParking(Parking parking) {

        if (repo.existsByVehicleNumber(parking.getVehicleNumber())) {
            throw new RuntimeException("Vehicle already exists");
        }

        if (repo.existsBySlotNumber(parking.getSlotNumber())) {
            throw new RuntimeException("Slot already occupied");
        }

        parking.setEntryTime(LocalDateTime.now());

        repo.save(parking);
    }

    public List<Parking> getAll() {
        return repo.findAll();
    }
}