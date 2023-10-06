package com.assignment.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Integer assignedCarId;
    private String usedCarIds;
    private Integer rating;
    private Integer salary;
    public Driver() {}
    public Driver(Integer id, String username, Integer assignedCarId, String usedCarIds, Integer rating,Integer salary) {
        this.id = id;
        this.username = username;
        this.assignedCarId = assignedCarId;
        this.usedCarIds = usedCarIds;
        this.rating = rating;
        this.salary=salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary= salary;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsedCarIds() {
        return usedCarIds;
    }

    public void setUsedCarIds(String usedCarIds) {
        this.usedCarIds = usedCarIds;
    }

    public Integer getAssignedCarId() {
        return assignedCarId;
    }

    public void setAssignedCarId(Integer assignedCarId) {
        this.assignedCarId = assignedCarId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating =rating;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", assignedCarId=" + assignedCarId +
                ", rating ="+rating+
                ", salary="+salary+
                ", usedCarIds='" + usedCarIds + '\'' +
                '}';
    }
}
