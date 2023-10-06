package com.assignment.cabservice.repository;

//import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Trip;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

@Transactional
public interface TripRepository extends JpaRepository<Trip,Integer> {
    //List<Car> findBySeatingCapacityAndavailableForBooking(int seatingCapacity,boolean availableForBooking);
    // List<Car> findBySeatingCapacityAndAvailableForBookingTrue(int seatingCapacity);

    // List<Car> findByIdIn(List<Integer> carIds);
    //List<Trip> findById(int carId);
    List<Trip> findByCarId(int carId);
    List<Trip> findById(int tripid);
    List<Trip> findByDriverId(int id);
    @Query("SELECT COUNT(t.source) FROM Trip t GROUP BY t.source")
    List<Integer> countUniqueSources();
    @Query("SELECT COUNT(t.destination) FROM Trip t GROUP BY t.destination")
    List<Integer> countUniqueDestinations();
}

