package com.assignment.cabservice.controller;

import com.assignment.cabservice.exception.InvalidSeatingCapacityException;
import com.assignment.cabservice.model.Trip;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.DriverRepository;
import com.assignment.cabservice.repository.TripRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class TripController {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CarRepository carRepository;

    @RequestMapping("payment")
    public String payment(@RequestParam int tripid, ModelMap modelMap) {

        List<Trip> trips = tripRepository.findById(tripid);
        modelMap.put("trips",trips);
        return "payment";
    }
    @GetMapping("/unique-sources")
    public String getUniqueSourcesPage(ModelMap modelMap) {
        List<Integer> uniqueSources = tripRepository.countUniqueSources();
        modelMap.put("uniqueSources", uniqueSources);
        return "dataAn";
    }

    @GetMapping("/unique-sources/count")
    @ResponseBody
    public List<Integer> countUniqueSources() {
        return tripRepository.countUniqueSources();
    }
    @GetMapping("/unique-sources1")
    public String getUniqueDestinationPage(ModelMap modelMap) {
        List<Integer> uniqueDestinations = tripRepository.countUniqueDestinations();
        modelMap.put("uniqueDestinations", uniqueDestinations);
        return "dataAn1";
    }

    @GetMapping("/unique-sources1/count")
    @ResponseBody
    public List<Integer> countUniqueDestinations() {
        return tripRepository.countUniqueDestinations();
    }
    @RequestMapping(value="tripDetails",method= RequestMethod.GET)
    public String tripDetails(Trip trip) {
        return "tripDetails";
    }
    @RequestMapping(value="tripDetails",method= RequestMethod.POST)
    public String addNewTrip(@RequestParam int carId,@RequestParam int driverId,Trip trip) {
        Car car1=carRepository.findById(carId).get();
        car1.setAvailableForBooking(false);
        carRepository.save(car1);
        trip.setCarId(carId);   
        trip.setDriverId(driverId);
        int s = trip.getSource();
        int d = trip.getDestination();
        trip.setCost(Math.abs(s-d)*500);
        tripRepository.save(trip);
        int id = trip.getTripid();
        return "redirect:payment?tripid="+Integer.toString(id);
    }
    @RequestMapping(value="pay",method= RequestMethod.GET)
    public String pay(Driver driver) {
        return "pay";
    }
    @RequestMapping(value="pay",method= RequestMethod.POST)
    public String pa(Driver driver,@RequestParam int id) {
        int d= driver.getRating();
        System.out.println(d);
        Driver driver1 = driverRepository.findById(id).get();
        int d1=driver1.getAssignedCarId();
        Car car1=carRepository.findById(d1).get();
        car1.setAvailableForBooking(true);
        carRepository.save(car1);
        int w=(d+driver1.getRating())/2;
        driver1.setRating(w);
        driverRepository.save(driver1);
        // tripRepository.updateRating(id,driver.getRating());
       
        return "welcome";
    }

    @RequestMapping(value = "trip-complete", method = RequestMethod.GET)
    public String tripComplete(@RequestParam int driverId, ModelMap modelMap){
        Driver driver = driverRepository.findById(driverId).get();
        modelMap.put("driver", driver);
        return "tripComplete";
    }

    @RequestMapping(value = "trip-complete",method = RequestMethod.POST)
    public String addRating(Driver driver) {
        int d=driver.getRating();
        // Driver savedDriver=driverRepository.save(driver);
        System.out.println(d);
        return "try";
    }

    /*
    @RequestMapping(value="add-driver",method= RequestMethod.GET)
    public String showNewDriverPage(Driver driver) {
        return "driver";
    }

    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="add-driver",method= RequestMethod.POST)
    public String addNewDriver(Driver driver) {
        driver.setPassword("$2a$12$TLJOLK.QjLRdxOHew1XMT.eYa2Xr5HMHaT14fRoI3gMOIZijNu9F2");//123
        driver.setUsedCarIds(""+driver.getAssignedCarId());
        Driver savedDriver=driverRepository.save(driver);
        Car car=carRepository.findById(driver.getAssignedCarId()).get();
        car.setDriverId(savedDriver.getId());
        carRepository.save(car);
        return "redirect:list-drivers";
    }
    */




    // @GetMapping("/tripDetails")
    
    // public BookingDetailDao bookCar(@RequestParam int carId, @RequestParam String username, ModelMap modelMap) {
    //     Car car=carRepository.findById(carId).get();
    //     car.setAvailableForBooking(false);
    //     Booking newBooking=new Booking();
    //     newBooking.setCarId(carId);
    //     newBooking.setDriverId(car.getDriverId());
    //     newBooking.setStatus("booked");
    //     newBooking.setUsername(username);
    //     carRepository.save(car);
    //     bookingRepository.save(newBooking);
    //     String cancelCarUrl="localhost:8080/cancel-car?bookingId="+newBooking.getId();
    //     BookingDetailDao bookingDetailDao=new BookingDetailDao(newBooking,cancelCarUrl);
    //     return bookingDetailDao;
    // }
    // public String TripController(){
    //     return "tripDetails";
    // }
    // @RequestMapping(value="tripDetails",method= RequestMethod.POST)
    // public String addNewTrip(Trip trip) {
    //     trip.cost(0);
    //     trip.setCarId(1);
    //     trip.tripid(1);
    //     trip.driverId(1);
        
    //     // driver.setUsedCarIds(""+driver.getAssignedCarId());
    //     // Driver savedDriver=driverRepository.save(driver);
    //     // Car car=carRepository.findById(driver.getAssignedCarId()).get();
    //     // car.setDriverId(savedDriver.getId());
    //     // carRepository.save(car);
    //     return "tripDetails";
    // }


    // @RequestMapping(value="add-driver",method= RequestMethod.POST)
    // public String addNewDriver(Driver driver) {
    //     driver.setPassword("$2a$12$TLJOLK.QjLRdxOHew1XMT.eYa2Xr5HMHaT14fRoI3gMOIZijNu9F2");//123
    //     driver.setUsedCarIds(""+driver.getAssignedCarId());
    //     Driver savedDriver=driverRepository.save(driver);
    //     Car car=carRepository.findById(driver.getAssignedCarId()).get();
    //     car.setDriverId(savedDriver.getId());
    //     carRepository.save(car);
    //     return "redirect:list-drivers";
    // }

    // @GetMapping("/showNewEmployeeForm")
	// public String showNewEmployeeForm(Model model) {
	// 	// create model attribute to bind form data
	// 	Employee employee = new Employee();
	// 	model.addAttribute("employee", employee);
	// 	return "new_employee";
	// }
}