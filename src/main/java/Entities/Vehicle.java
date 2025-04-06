package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String make;
    @Column
    private String model;
    private int year;
    private String licensePlate;
    private double dailyRate;
    private boolean isAvailable;

    @Override
    public String toString() {
        return id + ": " + make + " " + model + " (" + year + ") - " + licensePlate +
                " - $" + dailyRate + "/day - Available: " + isAvailable;
    }

    public void setPricePerDay(double v) {
    }
}
