package com.assignment.cabservice.controller;
import com.assignment.cabservice.model.Carpool;
import com.assignment.cabservice.repository.CarpoolRepository;
import com.assignment.cabservice.dao.DriverUseCarsDao;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Trip;
import com.assignment.cabservice.model.CarRequest;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.CarRequestRepository;
import com.assignment.cabservice.repository.DriverRepository;
import com.assignment.cabservice.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CarRequestRepository carRequestRepository;
    @Autowired
    private CarpoolRepository carpoolRepository;

    @RequestMapping("list-drivers")
    public String listAllDrivers(ModelMap modelMap) {
        List<Driver> drivers=driverRepository.findAll();
        modelMap.put("drivers",drivers);
        return "listDrivers";
    }

    @GetMapping("driver/used-cars")
    @ResponseBody
    public DriverUseCarsDao getCarsUsedByDriver(@RequestParam int driverId) throws Exception {
        Optional<Driver> driverOptional=driverRepository.findById(driverId);
        if(driverOptional.isPresent()) {
            Driver driver=driverOptional.get();
            String[] usedCars=driver.getUsedCarIds().split(",");
            List<Integer> carIds=new ArrayList<>();
            for(String cardId:usedCars) {
                carIds.add(Integer.parseInt(cardId));
            }

            List<Car> carList=carRepository.findByIdIn(carIds);
            DriverUseCarsDao driverUseCarsDao=new DriverUseCarsDao(driverId,driver.getUsername(),carList);

            return driverUseCarsDao;
        }

        throw new Exception("Driver not found");
    }

    @RequestMapping(value="add-driver",method= RequestMethod.GET)
    public String showNewDriverPage(Driver driver) {
        return "driver";
    }
    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="add-driver",method= RequestMethod.POST)
    public String addNewDriver(Driver driver) {
        driver.setPassword("$2a$12$TLJOLK.QjLRdxOHew1XMT.eYa2Xr5HMHaT14fRoI3gMOIZijNu9F2");//123
        driver.setUsedCarIds(""+driver.getAssignedCarId());
        driver.setRating(5);
        driver.setSalary(0);
        Driver savedDriver=driverRepository.save(driver);
        Carpool carpool = carpoolRepository.findById(driver.getAssignedCarId()).get();
        Car car=carRepository.findById(driver.getAssignedCarId()).get();
        carpool.setDriverId(savedDriver.getId());
        car.setDriverId(savedDriver.getId());
        carRepository.save(car);
        carpoolRepository.save(carpool);      
        return "redirect:list-drivers";
    }
    
    //http://localhost:8080/delete-driver?id=102
    @RequestMapping(value="delete-driver")
    public String deleteDriver(@RequestParam int id) throws Exception {
        Driver driver=driverRepository.findById(id).orElseThrow(() ->
                new Exception("Driver not found with driverID - " + id));
        Car car=carRepository.findById(driver.getAssignedCarId()).orElseThrow(() ->
                new Exception("Car not found with carID - " + driver.getAssignedCarId()));
        car.setAvailableForBooking(true);
        car.setDriverId(null);
        Carpool carpool = carpoolRepository.findById(driver.getAssignedCarId()).get();
        carpool.setDriverId(null);
        carpoolRepository.save(carpool);
        carRepository.save(car);
        driverRepository.deleteById(id);
        return "redirect:list-drivers";
    }



    @RequestMapping(value="get-salary")
    public String viewSal(@RequestParam int id,ModelMap modelMap)
    {
        List<Trip> trips=tripRepository.findByDriverId(id);
        Driver drivers=driverRepository.findById(id).get();
        int count=0;
        for (int i=0;i<trips.size();i++)
        {
            count=count+1;
        }
        drivers.setSalary(count*1000);
        driverRepository.save(drivers);
        System.out.println(drivers.getSalary());
        modelMap.put("drivers", drivers);
        return "viewsal";
    }
    //http://localhost:8080/request-car?driverId=102&carId=402
    @GetMapping(value="request-car")
    public String requestNewCar(@RequestParam int driverId,@RequestParam int carId) {
        CarRequest newCarRequest=new CarRequest();
        newCarRequest.setDriverId(driverId);
        newCarRequest.setCarId(carId);
        newCarRequest.setRequestStatus("PENDING");
        carRequestRepository.save(newCarRequest);
        return "redirect:list-car-requests";
    }

}
