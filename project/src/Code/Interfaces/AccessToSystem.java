package Code.Interfaces;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AccessToSystem class represents a login interface for accessing the system.
 * It allows users to enter their username and password, and provides login functionality.
 * The class extends JFrame and implements ActionListener and exceptionInterface.
 */
public class AccessToSystem extends JFrame implements ActionListener, exceptionInterface {

    private final JTextField userTextField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton resetButton;
    private final JCheckBox showPassword;

    /**
     * Constructs an instance of the AccessToSystem class.
     * Initializes the login interface components and sets up the layout.
     */
    public AccessToSystem() {
        //RTTI
        System.out.println(getClass());

        // Initialize components
        JLabel logo = new JLabel();
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Log In");
        resetButton = new JButton("Reset");
        showPassword = new JCheckBox("Show Password");

        // Set container layout
        Container container = getContentPane();
        container.setLayout(null);

        // Set logo properties
        ImageIcon icon = new ImageIcon("project/src/images/logoLogin.png");
        logo.setIcon(icon);
        logo.setBounds(140, 25, 100, 100);

        // Set label and text field properties
        JLabel userLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);

        // Set show password checkbox properties
        showPassword.setBounds(150, 250, 150, 30);

        // Set button properties
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 0, 0));
        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.setBackground(new Color(0, 0, 0));

        // Add components to the container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(logo);

        // Add action listeners
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    /**
     * Performs actions based on the events triggered by the components.
     * Implements the ActionListener interface method.
     *
     * @param e The ActionEvent object representing the event that occurred.
     */
    @Override
    public void actionPerformed (ActionEvent e){

        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("package") && pwdText.equalsIgnoreCase("FIIT")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();
                PackageSizeDeterminer actionWindow = new PackageSizeDeterminer();
                actionWindow.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    private class toConsole implements exceptionInterface{
        @Override
        public void printMessage(String message) {
            exceptionInterface.super.printMessage(message);
        }
    }
    /**
     * The entry point of the program.
     */
    public static void main(String[] a) {
        AccessToSystem frame = new AccessToSystem();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}