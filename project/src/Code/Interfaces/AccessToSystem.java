package Code.Interfaces;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AccessToSystem extends JFrame implements ActionListener, exceptionInterface  {
    private JLabel logo;
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Log In");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public AccessToSystem () {

        Container container = getContentPane();
        JLabel userLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        logo = new JLabel();
        container.setLayout(null);
        ImageIcon icon = new ImageIcon("project/src/images/logoLogin.png");

        logo.setIcon(icon);
        logo.setBounds(140, 25, 100, 100);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(logo);

        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 0, 0));

        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.setBackground(new Color(0, 0, 0));

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

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