package com.mysap.sd.shipment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysap.sd.shipment.entity.Shipment;
import com.mysap.sd.shipment.repository.ShipmentRepository;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepo;

    public ShipmentService(ShipmentRepository shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }

    public Shipment createShipment(Shipment shipment) {
        shipment.setCreatedAt(LocalDateTime.now());
        shipment.setUpdatedAt(LocalDateTime.now());
        shipment.getItems().forEach(item -> {
            item.setShipment(shipment);
            item.setCreatedAt(LocalDateTime.now());
            item.setUpdatedAt(LocalDateTime.now());
        });
        return shipmentRepo.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepo.findAll();
    }

    public Optional<Shipment> getShipmentById(String id) {
        return shipmentRepo.findById(id);
    }
}
