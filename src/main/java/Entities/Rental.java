
package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Rental")
@NoArgsConstructor
@Getter
@Setter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int vehicleId;

    @Column
    private int clientId;

    @Column
    private LocalDate rentalDate;

    @Column
    private LocalDate returnDate;

    @Column
    private double totalCost;

    @Override
    public String toString() {
        return "ID: " + id +
                ", Client ID: " + clientId +
                ", Vehicle ID: " + vehicleId +
                ", From: " + rentalDate +
                ", To: " + returnDate +
                ", Total Cost: " + totalCost;
    }
}