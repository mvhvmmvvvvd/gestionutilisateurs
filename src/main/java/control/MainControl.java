package control;

import model.Client;
import model.ClientDAO;
import view.MainView;

import javax.swing.*;

public class MainControl {
    private MainView view;
    private ClientDAO clientDAO;

    public MainControl(MainView view) {
        this.view = view;
        this.clientDAO = new ClientDAO();
        initialize();
        initController();
    }

    private void initialize() {
        view.setVisible(true);
        view.setClientTableData(clientDAO.getAllClients());
        view.setAddClientListener(e -> addClient());
        view.setEditClientListener(e -> editClient());
        view.setDeleteClientListener(e -> deleteClient());
    }

    private void initController() {
        view.getAddClientButton().addActionListener(e -> addClient());
        view.getViewClientsButton().addActionListener(e -> viewClients());
    }

    private void addClient() {
        String name = JOptionPane.showInputDialog(view, "Nom du client:");
        String email = JOptionPane.showInputDialog(view, "Email du client:");
        if (name != null && email != null) {
            clientDAO.addClient(new Client(clientDAO.getAllClients().size() + 1, name, email));
            JOptionPane.showMessageDialog(view, "Client ajouté avec succès !");
        }
    }

    private void viewClients() {
        StringBuilder clientsList = new StringBuilder("Liste des Clients:\n");
        for (Client client : clientDAO.getAllClients()) {
            clientsList.append(client.getId()).append(". ").append(client.getName()).append(" - ").append(client.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(view, clientsList.toString());
    }

    private void editClient() {
        int selectedRow = view.getSelectedClientRow();
        if (selectedRow >= 0) {
            Client client = clientDAO.getClient(view.getClientId(selectedRow));
            view.setClientFormData(client);
            if (view.isClientFormSubmitted()) {
                clientDAO.updateClient(client);
                view.setClientTableData(clientDAO.getAllClients());
            }
        }
    }

    private void deleteClient() {
        int selectedRow = view.getSelectedClientRow();
        if (selectedRow >= 0) {
            clientDAO.deleteClient(view.getClientId(selectedRow));
            view.setClientTableData(clientDAO.getAllClients());
        }
    }
}