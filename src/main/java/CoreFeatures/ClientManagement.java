package CoreFeatures;

import Entities.Client;

import java.util.List;
import java.util.Scanner;

public class ClientManagement {
    private List<Client> clients;
    private Scanner scanner;

public void addClient() {
    System.out.print("Name: ");
    String Name = scanner.nextLine();
    System.out.print("Surname: ");
    String Surname = scanner.nextLine();
    System.out.print("Phone : ");
    int Phone = scanner.nextInt();
    scanner.nextLine();
    String email = scanner.nextLine();
    System.out.print("email: ");

    Client c = new Client(Name, Surname, Phone, email);
    clients.add(c);
    System.out.println("Client added successfully.");
}


    }





