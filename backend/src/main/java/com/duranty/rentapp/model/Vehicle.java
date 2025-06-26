package com.duranty.rentapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String brand;
    private String model;
    private int year;
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // public Vehicle() {
    // }

    // public Vehicle(String brand, String model, int year, double dailyPrice) {
    // this.brand = brand;
    // this.model = model;
    // this.year = year;
    // this.dailyPrice = dailyPrice;
    // }

    // public Long getId() {
    // return id;
    // }

    // public String getBrand() {
    // return brand;
    // }

    // public void setBrand(String brand) {
    // this.brand = brand;
    // }

    // public String getModel() {
    // return model;
    // }

    // public void setModel(String model) {
    // this.model = model;
    // }

    // public int getYear() {
    // return year;
    // }

    // public void setYear(int year) {
    // this.year = year;
    // }

    // public double getDailyPrice() {
    // return dailyPrice;
    // }

    // public void setDailyPrice(double dailyPrice) {
    // this.dailyPrice = dailyPrice;
    // }
}
