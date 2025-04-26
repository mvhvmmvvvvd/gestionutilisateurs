import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientForm extends JDialog {
    private JTextField nameField;
    private JTextField emailField;
    private JCheckBox adPreferencesCheckBox;
    private JButton saveButton;
    private JButton cancelButton;

    public ClientForm(Frame parent) {
        super(parent, "Client Form", true);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Receive Advertisements:"));
        adPreferencesCheckBox = new JCheckBox();
        add(adPreferencesCheckBox);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to save client information
                dispose();
            }
        });
        add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelButton);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public String getClientName() {
        return nameField.getText();
    }

    public String getClientEmail() {
        return emailField.getText();
    }

    public boolean isAdPreferencesChecked() {
        return adPreferencesCheckBox.isSelected();
    }
}