package CoreFeatures;

import Entities.Client;
import Util.Helper;

import java.util.List;
import java.util.Scanner;

public class ClientManagement {
    private List<Client> clients;
    private Scanner scanner;

    public void addClient() {
        Client c = new Client();
        System.out.print("Name: ");
        c.setName(Helper.getStringFromUser());
        System.out.print("Surname: ");
        c.setSurname(Helper.getStringFromUser());
        System.out.print("Phone : ");
        c.setPhone(Helper.getStringFromUser());
        System.out.print("Email: ");
        c.setEmail(Helper.getStringFromUser());

        clients.add(c);
        System.out.println("Client added successfully.");
    }

}







