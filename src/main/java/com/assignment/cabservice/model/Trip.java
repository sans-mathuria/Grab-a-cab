package com.assignment.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Trip {

    @Id
    @GeneratedValue
    private Integer tripid;
    private Integer carId;
    private Integer driverId;
    private Integer cost;
    private Integer source;
    private Integer destination;

    public Integer getTripid() {
        return tripid;
    }

    public void setId(Integer Tripid) {
        this.tripid = tripid;
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




    @Override
    public String toString() {
        return "Trip{" +
                "Trip id=" + tripid +
                ", carId=" + carId +
                ", driverId=" + driverId +
                ", cost='" + cost + '\'' +
                '}';
    }
}
