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


   @Override
    public String toString() {
        return id + ": Client ID " + client + ", Vehicle ID " + vehicle + ", From " + rentalDate + " to " + returnDate + ", Cost: $" + total;
    }


}
