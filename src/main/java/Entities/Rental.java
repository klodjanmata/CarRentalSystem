package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Vehicle vehicle; // many to one
    private Client client; // many to one
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double total;


    public void setClientId(int intFromUser) {
    }

    public void setTotalCost(double doubleFromUser) {
    }

    public Long VehicleId() {
        return id ;
    }

    public Long getClientId() {
        return id;
    }

    public Long getTotalCost() {
        return id;
    }

    public void setVehicleId(int intFromUser) {
    }
}