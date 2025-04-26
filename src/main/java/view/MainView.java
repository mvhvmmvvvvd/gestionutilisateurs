package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JTable clientTable;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private MainControl mainControl;
    private JButton addClientButton;
    private JButton viewClientsButton;

    public MainView(MainControl mainControl) {
        this.mainControl = mainControl;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Gestion des Clients et Publicités");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addClientButton = new JButton("Ajouter un Client");
        viewClientsButton = new JButton("Voir les Clients");

        setLayout(new FlowLayout());
        add(addClientButton);
        add(viewClientsButton);

        clientTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(clientTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Client");
        editButton = new JButton("Edit Client");
        deleteButton = new JButton("Delete Client");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainControl.showClientForm(null);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = clientTable.getSelectedRow();
                if (selectedRow != -1) {
                    mainControl.showClientForm(mainControl.getClientAt(selectedRow));
                } else {
                    JOptionPane.showMessageDialog(MainView.this, "Please select a client to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = clientTable.getSelectedRow();
                if (selectedRow != -1) {
                    mainControl.deleteClient(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(MainView.this, "Please select a client to delete.");
                }
            }
        });
    }

    public void refreshClientTable() {
        // Logic to refresh the client table data
    }

    public JButton getAddClientButton() {
        return addClientButton;
    }

    public JButton getViewClientsButton() {
        return viewClientsButton;
    }
}