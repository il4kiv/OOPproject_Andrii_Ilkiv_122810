package Code.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 This class represents a graphical user interface for determining the size of a package.
 It allows users to input the height, width, and length of a package and determine whether it's small or big.
 If it's small, it will open the interfaceSmallParcel window, otherwise, it will open the interfaceBigParcel window.
 The class extends JFrame and implements ActionListener and exceptionInterface interfaces.
 */
public class PackageSizeDeterminer extends JFrame implements ActionListener, exceptionInterface {

    private final JTextField heightField;
    private final JTextField widthField;
    private final JTextField lengthField;

    /**
     * Constructor for the PackageSizeDeterminer class. It sets up the GUI by creating and arranging
     * the components and setting the properties of the window.
     */
    public PackageSizeDeterminer() {
        // RTTI
        System.out.println(getClass());

        setTitle("Package Size");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(6, 2));

        JLabel heightLabel = new JLabel("Enter height (in cm):");
        heightField = new JTextField(10);
        JPanel heightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);
        container.add(heightPanel);

        JLabel widthLabel = new JLabel("Enter  width  (in cm):");
        widthField = new JTextField(10);
        JPanel widthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        widthPanel.add(widthLabel);
        widthPanel.add(widthField);
        container.add(widthPanel);

        JLabel lengthLabel = new JLabel("Enter length (in cm):");
        lengthField = new JTextField(10);
        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthField);
        container.add(lengthPanel);

        JButton determineButton = new JButton("Determine Size");
        determineButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(determineButton);
        container.add(buttonPanel);

        JLabel sizeLabel = new JLabel();
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sizePanel.add(sizeLabel);
        container.add(sizePanel);

        setVisible(true);
        setLocationRelativeTo(null);

    }

    /**
     * Overrides the actionPerformed method of ActionListener interface to determine the size of a package
     * based on user inputs. It retrieves the height, width, and length inputs and performs a background computation
     * using a SwingWorker to determine whether the package is small or big. If it's small, it will open the
     * interfaceSmallParcel window, otherwise, it will open the interfaceBigParcel window.
     * @param e an ActionEvent object representing the user's action
     */
        @Override
        public void actionPerformed(ActionEvent e) {
        if (heightField.getText().isEmpty() || widthField.getText().isEmpty() || lengthField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter full size!");
            return;
        }


        double height = Double.parseDouble(heightField.getText());
        double width = Double.parseDouble(widthField.getText());
        double length = Double.parseDouble(lengthField.getText());
        // Creatng a SwingWorker to perform the computation in the background thread
        new SwingWorker() {
            public Object doInBackground() {
                if (height <= 50 && width <= 50 && length <= 50) {
                    printMessage(String.valueOf(height));
                    printMessage(String.valueOf(width));
                    printMessage(String.valueOf(length));
                    JOptionPane.showMessageDialog(PackageSizeDeterminer.this, "Your package is small");
                    dispose();
                    interfaceSmallParcel actionWindow = new interfaceSmallParcel();
                    actionWindow.setVisible(true);
                } else {
                    printMessage(String.valueOf(height));
                    printMessage(String.valueOf(width));
                    printMessage(String.valueOf(length));
                    JOptionPane.showMessageDialog(PackageSizeDeterminer.this, "Your package is big");
                    dispose();
                    interfaceBigParcel actionWindow = new interfaceBigParcel();
                    actionWindow.setVisible(true);
                }
                return null;
            }
        }.execute();
    }
}