package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClientForm extends JFrame {
    private final JTextField nomField;
    private final JTextField prenomField;
    private final JTextField telephoneField;
    private final JTextField villeField;
    private final JTextField emailField;
    private final JButton saveButton;
    private final JButton cancelButton;

    public ClientForm() {
        setTitle("Formulaire Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel nomLabel = new JLabel("Nom:");
        nomField = new JTextField(20);

        JLabel prenomLabel = new JLabel("Prénom:");
        prenomField = new JTextField(20);

        JLabel telephoneLabel = new JLabel("Téléphone:");
        telephoneField = new JTextField(20);

        JLabel villeLabel = new JLabel("Ville:");
        villeField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        saveButton = new JButton("Enregistrer");
        cancelButton = new JButton("Annuler");

        setLayout(new GridLayout(6, 2, 10, 10));
        add(nomLabel);
        add(nomField);
        add(prenomLabel);
        add(prenomField);
        add(telephoneLabel);
        add(telephoneField);
        add(villeLabel);
        add(villeField);
        add(emailLabel);
        add(emailField);
        add(saveButton);
        add(cancelButton);
    }

    public JTextField getNomField() {
        return nomField;
    }

    public JTextField getPrenomField() {
        return prenomField;
    }

    public JTextField getTelephoneField() {
        return telephoneField;
    }

    public JTextField getVilleField() {
        return villeField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}