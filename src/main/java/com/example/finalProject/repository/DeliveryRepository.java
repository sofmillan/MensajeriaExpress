package com.example.finalProject.repository;

import com.example.finalProject.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {
}
