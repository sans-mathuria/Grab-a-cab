package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.Carpool;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CarpoolRepository extends JpaRepository<Carpool,Integer> {
    Carpool findByCarId(Integer carId);
    void deleteByCarId(Integer carId);

}