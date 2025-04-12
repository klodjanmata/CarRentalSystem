package Service;

import Entities.Client;
import Repository.ClientRepository;
import Util.Helper;

import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public void addClient () {
        System.out.println("Adding new Client: ");
        Client c = new Client();
        System.out.println("Add Client ID: ");
        c.setId(Helper.getIntFromUser());
        System.out.println("Add Clients Name: ");
        c.setName(Helper.getStringFromUser());
        System.out.println("Add Clients Surname: ");
        c.setSurname(Helper.getStringFromUser());
        System.out.println("Add phone: ");
        c.setPhone(Helper.getStringFromUser());
        System.out.println("Add email: ");
        c.setEmail(Helper.getStringFromUser());

        clientRepository.save(c);
    }

    public void UpdateClient () {
        System.out.print("Enter Cliend Id:");
        int clientID = Helper.getIntFromUser();
        Client c = clientRepository.getClientById(clientID);
        if (c == null) {
            System.out.println("Client not found");
            return;
        }
        System.out.println("Add Client ID: ");
        c.setId(Helper.getIntFromUser());
        System.out.println("Add Clients Name: ");
        c.setName(Helper.getStringFromUser());
        System.out.println("Add Clients Surname: ");
        c.setSurname(Helper.getStringFromUser());
        System.out.println("Add phone: ");
        c.setPhone(Helper.getStringFromUser());
        System.out.println("Add email: ");
        c.setEmail(Helper.getStringFromUser());
        clientRepository.save(c);


    }

    public void DeleteClient () {
        System.out.print("Enter Client ID to Delete");
        int clientID = Helper.getIntFromUser();
        Client c = clientRepository.getClientById(clientID);
        clientRepository.delete(c);
        System.out.print("Deleted successfully");


    }

    public void ViewClientList () {
        System.out.print("View Client List");
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            System.out.println("No clients available");
        } else {
            for (Client c : clients) {
                System.out.print(c);
            }
        }

    }

}