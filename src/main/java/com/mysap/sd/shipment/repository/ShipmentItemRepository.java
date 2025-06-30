package com.mysap.sd.shipment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.shipment.entity.ShipmentItem;

public interface ShipmentItemRepository extends JpaRepository<ShipmentItem, String> {
    List<ShipmentItem> findByShipmentId(String shipmentId);
}