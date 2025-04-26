package model;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private List<Client> clients = new ArrayList<>();

    public List<Client> getAllClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void updateClient(int id, Client updatedClient) {
        for (Client client : clients) {
            if (client.getId() == id) {
                client.setName(updatedClient.getName());
                client.setEmail(updatedClient.getEmail());
                break;
            }
        }
    }

    public void deleteClient(int id) {
        clients.removeIf(client -> client.getId() == id);
    }
}