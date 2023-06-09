package com.example.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.finalProject.model.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {
}
