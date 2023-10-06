package com.assignment.cabservice.repository;

//import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Rental;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface RentalRepository extends JpaRepository<Rental,Integer> {
    // List<Rental> findById(int rentalId);
    // List<Rental> findByCarId(int carId);
}

