package control;

import javax.swing.JOptionPane;

import model.Client;
import model.ClientDAO;
import view.ClientForm;
import view.MainView;

public class MainControl {
    private final MainView view;
    private final ClientDAO clientDAO;

    public MainControl(MainView view) {
        this.view = view;
        this.clientDAO = new ClientDAO();
        initialize();
    }

    private void initialize() {
        view.setClientTableData(clientDAO.getAllClients());
        view.getAddClientButton().addActionListener(e -> addClient());
        view.getEditClientButton().addActionListener(e -> editClient());
        view.getDeleteClientButton().addActionListener(e -> deleteClient());
        view.getViewClientsButton().addActionListener(e -> viewClients());
    }

    private void addClient() {
        ClientForm clientForm = new ClientForm();
        clientForm.setVisible(true);

        clientForm.getSaveButton().addActionListener(e -> {
            String nom = clientForm.getNomField().getText();
            String prenom = clientForm.getPrenomField().getText();
            String telephone = clientForm.getTelephoneField().getText();
            String ville = clientForm.getVilleField().getText();
            String email = clientForm.getEmailField().getText();

            if (nom.isEmpty() || prenom.isEmpty() || telephone.isEmpty() || ville.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(clientForm, "Tous les champs sont obligatoires !");
            } else {
                clientDAO.addClient(new Client(clientDAO.getAllClients().size() + 1, nom, prenom, telephone, ville, email));
                JOptionPane.showMessageDialog(clientForm, "Client ajouté avec succès !");
                view.setClientTableData(clientDAO.getAllClients());
                clientForm.dispose();
            }
        });

        clientForm.getCancelButton().addActionListener(e -> clientForm.dispose());
    }

    private void editClient() {
        int selectedRow = view.getSelectedClientRow();
        if (selectedRow >= 0) {
            int clientId = view.getClientId(selectedRow);
            Client client = clientDAO.getClient(clientId);
            if (client != null) {
                ClientForm clientForm = new ClientForm();
                clientForm.getNomField().setText(client.getNom());
                clientForm.getPrenomField().setText(client.getPrenom());
                clientForm.getTelephoneField().setText(client.getTelephone());
                clientForm.getVilleField().setText(client.getVille());
                clientForm.getEmailField().setText(client.getEmail());
                clientForm.setVisible(true);

                clientForm.getSaveButton().addActionListener(e -> {
                    String nom = clientForm.getNomField().getText();
                    String prenom = clientForm.getPrenomField().getText();
                    String telephone = clientForm.getTelephoneField().getText();
                    String ville = clientForm.getVilleField().getText();
                    String email = clientForm.getEmailField().getText();

                    if (nom.isEmpty() || prenom.isEmpty() || telephone.isEmpty() || ville.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(clientForm, "Tous les champs sont obligatoires !");
                    } else {
                        client.setNom(nom);
                        client.setPrenom(prenom);
                        client.setTelephone(telephone);
                        client.setVille(ville);
                        client.setEmail(email);
                        clientDAO.updateClient(clientId, client);
                        JOptionPane.showMessageDialog(clientForm, "Client modifié avec succès !");
                        view.setClientTableData(clientDAO.getAllClients());
                        clientForm.dispose();
                    }
                });

                clientForm.getCancelButton().addActionListener(e -> clientForm.dispose());
            } else {
                JOptionPane.showMessageDialog(view, "Client introuvable !");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Veuillez sélectionner un client à modifier !");
        }
    }

    private void deleteClient() {
        int selectedRow = view.getSelectedClientRow();
        if (selectedRow >= 0) {
            int clientId = view.getClientId(selectedRow);
            clientDAO.deleteClient(clientId);
            JOptionPane.showMessageDialog(view, "Client supprimé avec succès !");
            view.setClientTableData(clientDAO.getAllClients());
        } else {
            JOptionPane.showMessageDialog(view, "Veuillez sélectionner un client à supprimer !");
        }
    }

    private void viewClients() {
        StringBuilder clientsList = new StringBuilder("Liste des Clients:\n");
        for (Client client : clientDAO.getAllClients()) {
            clientsList.append(client.getId()).append(". ").append(client.getNom()).append(" ").append(client.getPrenom())
                    .append(" - ").append(client.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(view, clientsList.toString());
    }
}