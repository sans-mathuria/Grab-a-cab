package com.assignment.cabservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Carpool {

    @Id
    private Integer id;
    private Integer carId;
    private Integer driverId;
    private Integer carCapacity;
    private Integer seatsLeft;
    private boolean isFull;
    private boolean isStarted;
    private Integer cost;
    private Integer source;
    private Integer destination;

    public Carpool(){
    }
    // public Carpool(Integer id, Integer carId, Integer driverId, Integer carCapacity, Integer seatsLeft, Integer cost, Integer source, Integer destination, boolean isFull){
    //     this.id = id;
    //     this.driverId = driverId;
    //     this.carId = carId;
    //     this.source = source;
    //     this.destination = destination;
    //     this.carCapacity = carCapacity;
    //     this.cost = cost;
    //     this.isFull = isFull;
    //     this.seatsLeft = seatsLeft;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setIsStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public boolean getIsStarted() {
        return isStarted;
    }

    public void setSeatsLeft(Integer seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public Integer getSeatsLeft() {
        return seatsLeft;
    }


    @Override
    public String toString() {
        return "Carpool{" +
                "id=" + id +
                ", carId=" + carId +
                ", driverId=" + driverId +
                ", carCapacity=" + carCapacity +
                ", seatsLeft=" + seatsLeft +
                ", isFull=" + isFull +
                ", isStarted=" + isStarted +
                ", source=" + source +
                ", destination=" + destination +             
                ", cost='" + cost + '\'' +
                '}';
    }
}