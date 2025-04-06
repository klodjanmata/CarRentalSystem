package Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Client")
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Surname;

    @Column
    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    public Client(String name, String surname, int phone, String email) {
    }

    @Override
    public String toString() {
        return "Client ID: " + id +
                ", Name: " + Name + " " + Surname +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}