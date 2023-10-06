package com.assignment.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Rental {

    @Id
    @GeneratedValue
    private Integer rentalId;
    private Integer carId;
    private Integer cost;
    private Integer days;

    public Integer getrentalId() {
        return rentalId;
    }

    public void setrentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", carId=" + carId +
                ", days=" + days +
                ", cost='" + cost + '\'' +
                '}';
    }
}
