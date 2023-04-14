package com.example.finalProject.repository;

import com.example.finalProject.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {

    @Query("Select d from Delivery d where d.deliveryStatus = ?1")
    public List<Delivery> filterByStatus(String status);
}
