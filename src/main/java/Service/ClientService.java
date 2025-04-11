package Service;

import Entities.Client;
import Repository.ClientRepository;
import Util.Helper;

public class ClientService {

    public void addClient() {
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

        ClientRepository.save(c);
    }
}
