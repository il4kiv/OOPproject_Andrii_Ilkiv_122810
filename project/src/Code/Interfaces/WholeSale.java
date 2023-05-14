package Code.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 This class represents a graphical user interface for a wholesale application.
 It allows users to input their personal information and the cost of a parcel,
 and submit the information by clicking the submit button.
 The class extends JFrame and creates a window with various input fields and a submit button.
 */
public class WholeSale extends JFrame {
    private final JTextField nameField;
    private final JTextField surnameField;
    private final JTextField gmailField;
    private final JTextField phoneField;
    private final JTextField companyField;
    private final JSlider costSlider;

    /**
     * Constructor for the WholeSale class. It sets up the GUI by creating and arranging
     * the components and setting the properties of the window.
     */
    public WholeSale() {
        // Set up the JFrame
        setTitle("WholeSale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set custom UI look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // RTTI
        System.out.println(getClass());

        Container container = getContentPane();
        container.setLayout(new GridLayout(8, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameField = new JTextField(20);
        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        surnameField = new JTextField(20);
        JLabel gmailLabel = new JLabel("Gmail:");
        gmailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gmailField = new JTextField(20);
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        phoneField = new JTextField(20);
        JLabel companyLabel = new JLabel("Company Name:");
        companyLabel.setFont(new Font("Arial", Font.BOLD, 16));
        companyField = new JTextField(20);
        JLabel costLabel = new JLabel("Parcel Cost:");
        costLabel.setFont(new Font("Arial", Font.BOLD, 16));
        costSlider = new JSlider(JSlider.HORIZONTAL, 0, 100000, 0);
        costSlider.setMajorTickSpacing(20000);
        costSlider.setPaintTicks(true);
        costSlider.setPaintLabels(true);


        nameLabel.setForeground(new Color(31, 57, 147));
        surnameLabel.setForeground(new Color(31, 57, 147));
        gmailLabel.setForeground(new Color(31, 57, 147));
        phoneLabel.setForeground(new Color(31, 57, 147));
        companyLabel.setForeground(new Color(31, 57, 147));
        costLabel.setForeground(new Color(31, 57, 147));
        nameField.setBackground(new Color(230, 230, 230));
        surnameField.setBackground(new Color(230, 230, 230));
        gmailField.setBackground(new Color(230, 230, 230));
        phoneField.setBackground(new Color(230, 230, 230));
        companyField.setBackground(new Color(230, 230, 230));
        costSlider.setBackground(new Color(230, 230, 230));

        container.add(nameLabel);
        container.add(nameField);
        container.add(surnameLabel);
        container.add(surnameField);
        container.add(gmailLabel);
        container.add(gmailField);
        container.add(phoneLabel);
        container.add(phoneField);
        container.add(companyLabel);
        container.add(companyField);
        container.add(costLabel);
        container.add(costSlider);

        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(new Color(83, 120, 229));
        submitButton.setBackground(new Color(52, 94, 238));
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        submitButton.addActionListener(new ActionListener() {

            /**
             ActionListener implementation for the submitButton. It retrieves the values
             entered in the text fields and slider, displays them in a JOptionPane dialog,
             and optionally resets the form fields.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String gmail = gmailField.getText();
                String phone = phoneField.getText();
                String company = companyField.getText();
                int cost = costSlider.getValue();

                JOptionPane.showMessageDialog(WholeSale.this,
                        "Name: " + name + "\n" +
                                "Surname: " + surname + "\n" +
                                "Gmail: " + gmail + "\n" +
                                "Phone Number: " + phone + "\n" +
                                "Company Name: " + company + "\n" +
                                "Parcel Cost: $" + cost);

                // Optional: Reset the form fields
                nameField.setText("");
                surnameField.setText("");
                gmailField.setText("");
                phoneField.setText("");
                companyField.setText("");
                costSlider.setValue(0);
            }
        });

        container.add(new JLabel());
        container.add(submitButton);

        pack();
        setVisible(true);
    }
}