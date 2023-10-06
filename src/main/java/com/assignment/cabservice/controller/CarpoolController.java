package com.assignment.cabservice.controller;

import com.assignment.cabservice.exception.InvalidSeatingCapacityException;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Carpool;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.CarpoolRepository;
import com.assignment.cabservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CarpoolController {

    @Autowired
    private CarpoolRepository carpoolRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;


    @RequestMapping(value="list-carpool-cars",method= RequestMethod.GET)
    public String listAllCarpoolCars(ModelMap modelMap) {
        List<Carpool> carpools=carpoolRepository.findAll();
        modelMap.put("carpools",carpools);
        return "listCarpoolCars";
    }

    @RequestMapping(value="carpool-details")
    public String bookCarpoolCars(ModelMap modelMap,@RequestParam int id,@RequestParam boolean isStarted,@RequestParam int carCapacity,@RequestParam int seatsLeft){
        
        Carpool carpool=carpoolRepository.findById(id).get();
        if(seatsLeft>0){
            carpool.setSeatsLeft(seatsLeft-1);
            seatsLeft=seatsLeft-1;
        }
        if(seatsLeft==0){
            carpool.setIsFull(true);
            modelMap.put("carpool",carpool);
            carpoolRepository.save(carpool);
            return "fullBooked";
        }
        modelMap.put("carpool",carpool);
        if(!isStarted)
        {
            carpool.setIsStarted(true);
            carpoolRepository.save(carpool);
            return "redirect:start-carpool?id="+Integer.toString(id);
        }

        carpoolRepository.save(carpool);
        return "redirect:list-carpool-cars";
    }

    @RequestMapping(value="complete-carpool")
    public String rentDone(@RequestParam int id) {
        Carpool carpool = carpoolRepository.findById(id).get();
        Car car1=carRepository.findById(id).get();
        car1.setAvailableForBooking(true);
        carpool.setIsStarted(false);
        carpool.setIsFull(false);
        carpool.setDestination(0);
        carpool.setSource(0);
        carpoolRepository.save(carpool);
        carpool.setSeatsLeft(carpool.getCarCapacity());
        carRepository.save(car1);

        // tripRepository.updateRating(id,driver.getRating());
        //System.out.println(d);
        return "welcome";
    }

    @RequestMapping(value="start-carpool",method= RequestMethod.GET)
    public String showNewCarpool(Carpool carpool) {
        return "carpool";
    }

    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="start-carpool",method= RequestMethod.POST)
    public String showNewestCarpool(@RequestParam int id, Carpool carpool) {

        Car car1=carRepository.findById(id).get();
        car1.setAvailableForBooking(false);
        Carpool carpool1 = carpoolRepository.findById(id).get();
        int dest = carpool.getDestination();
        int s = carpool.getSource();
        carpool1.setSource(s);
        carpool1.setDestination(dest);

        int cost = Math.abs(s-dest)*100/(carpool1.getCarCapacity());
        carpool1.setIsStarted(true);
        carpool1.setSeatsLeft(carpool1.getSeatsLeft());
        carpool1.setCost(cost);
        carpoolRepository.save(carpool1);
        carRepository.save(car1);
        
        return "redirect:list-carpool-cars";
    }

    // //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    // @RequestMapping(value="add-car",method= RequestMethod.POST)
    // public String addNewCar(Car car) throws Exception {
    //     int capacity=car.getSeatingCapacity();
    //     if(capacity!=3 && capacity!=4 && capacity!=7) {
    //         throw  new InvalidSeatingCapacityException("Allowed capacities are: {3,4,7}");
    //     }

    //     car.setAvailableForBooking(true);
    //     carRepository.save(car);
    //     return "redirect:list-cars";
    // }



}