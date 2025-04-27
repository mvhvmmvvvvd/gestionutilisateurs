package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Client;

public class MainView extends JFrame {
    private final JTable clientTable;
    private final JButton addClientButton;
    private final JButton editClientButton;
    private final JButton deleteClientButton;
    private final JButton viewClientsButton; // Nouveau bouton
    private boolean clientFormSubmitted;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField prenomField;
    private JTextField telephoneField;
    private JTextField villeField;

    public MainView() {
        setTitle("Tableau de bord - Gestion des Clients");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        clientTable = new JTable();
        addClientButton = new JButton("Ajouter");
        editClientButton = new JButton("Modifier");
        deleteClientButton = new JButton("Supprimer");
        viewClientsButton = new JButton("Voir les Clients"); // Initialisation du bouton

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addClientButton);
        buttonPanel.add(editClientButton);
        buttonPanel.add(deleteClientButton);
        buttonPanel.add(viewClientsButton); // Ajout du bouton au panneau

        setLayout(new BorderLayout());
        add(new JScrollPane(clientTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        clientFormSubmitted = false; // Par défaut, le formulaire n'est pas soumis

        nameField = new JTextField(20);
        prenomField = new JTextField(20);
        telephoneField = new JTextField(20);
        villeField = new JTextField(20);
        emailField = new JTextField(20);
    }

    public void setClientTableData(List<Client> clients) {
        String[] columnNames = {"ID", "Nom", "Prénom", "Téléphone", "Ville", "Email"};
        String[][] data = new String[clients.size()][6];
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            data[i][0] = String.valueOf(client.getId());
            data[i][1] = client.getNom();
            data[i][2] = client.getPrenom();
            data[i][3] = client.getTelephone();
            data[i][4] = client.getVille();
            data[i][5] = client.getEmail();
        }
        clientTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public void setAddClientListener(java.awt.event.ActionListener listener) {
        addClientButton.addActionListener(listener);
    }

    public void setEditClientListener(java.awt.event.ActionListener listener) {
        editClientButton.addActionListener(listener);
    }

    public void setDeleteClientListener(java.awt.event.ActionListener listener) {
        deleteClientButton.addActionListener(listener);
    }

    public int getSelectedClientRow() {
        return clientTable.getSelectedRow();
    }

    public int getClientId(int row) {
        return Integer.parseInt(clientTable.getValueAt(row, 0).toString());
    }

    public JButton getAddClientButton() {
        return addClientButton;
    }

    public JButton getEditClientButton() {
        return editClientButton;
    }

    public JButton getDeleteClientButton() {
        return deleteClientButton;
    }

    public JButton getViewClientsButton() { // Méthode d'accès pour le bouton
        return viewClientsButton;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public boolean isClientFormSubmitted() {
        return clientFormSubmitted;
    }

    public void setClientFormSubmitted(boolean submitted) {
        this.clientFormSubmitted = submitted;
    }

    public void setClientFormData(Client client) {
        nameField.setText(client.getNom());
        emailField.setText(client.getEmail());
    }

    public Client getClientFormData() {
        return new Client(
            0, 
            nameField.getText(), 
            prenomField.getText(), 
            telephoneField.getText(), 
            villeField.getText(), 
            emailField.getText()
        );
    }
}