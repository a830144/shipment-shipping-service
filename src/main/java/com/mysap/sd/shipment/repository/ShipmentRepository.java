package com.mysap.sd.shipment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.shipment.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    List<Shipment> findByOrderId(String orderId);
}
