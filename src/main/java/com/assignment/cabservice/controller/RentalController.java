package com.assignment.cabservice.controller;

import com.assignment.cabservice.exception.InvalidSeatingCapacityException;
import com.assignment.cabservice.model.Trip;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.model.Rental;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.RentalRepository;
import com.assignment.cabservice.repository.DriverRepository;
import com.assignment.cabservice.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RentalController {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value="rent-details",method= RequestMethod.GET)
    public String rentalDetails(Rental rental) {
        return "rentalDetails";
    }

    @RequestMapping(value="rent-details",method= RequestMethod.POST)
    public String addNewRental(@RequestParam int carId,Rental rental,ModelMap modelMap) {
        Car car1=carRepository.findById(carId).get();
        car1.setAvailableForBooking(false);
        carRepository.save(car1);
        rental.setCarId(carId);  
        int days = rental.getDays();
        System.out.println(days);
        rental.setCost(days*1000);
        rentalRepository.save(rental);
        modelMap.put("rental",rental);
        return "paymentRentPage";
    }

    // @RequestMapping("payment-rent")
    // public String paymentRent(@RequestParam int carId, ModelMap modelMap) {
    //     List<Rental> rentals = rentalRepository.findByCarId(carId);
    //     modelMap.put("rentals",rentals);
    //     return "paymentRentPage";
    // }

    @RequestMapping(value="complete-rental")
    public String rentDone(@RequestParam int carId) {
        Car car1=carRepository.findById(carId).get();
        car1.setAvailableForBooking(true);
        carRepository.save(car1);
        // tripRepository.updateRating(id,driver.getRating());
        //System.out.println(d);
        return "welcome";
    }


}