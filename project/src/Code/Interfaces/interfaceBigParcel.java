package Code.Interfaces;

import Code.Delivery.DeliveryOption;
import Code.Delivery.PrimeDelivery;
import Code.Destinations.*;
import Code.Parcel.BigParcel;
import Code.Parcel.Parcel;
import Code.Parcel.SmallParcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**

 This class represents the graphical user interface for calculating the cost of shipping a big parcel.
 It extends JFrame and implements the ActionListener and exceptionInterface interfaces.
 It contains fields for entering the package weight, selecting the destination, and choosing whether or not to add insurance.
 It also includes a button for calculating the cost and a label for displaying the result.
 If the package is fragile, it opens a new window for filling out wholesale information.
 */
public class interfaceBigParcel extends JFrame implements ActionListener, exceptionInterface {

    protected final JLabel costLabel;
    protected final JTextField weightField;
    protected final JComboBox<String> destinationBox;
    protected final JRadioButton fragileYes;
    protected final JCheckBox insuranceCheckbox;


    /**
     * Constructs a new interfaceBigParcel object, sets the title, size, default close operation, and layout of the JFrame.
     * It then creates various Swing components such as text fields, radio buttons, and check boxes.
     * It also adds an action listener to the calculateButton.
     * The costLabel is initialized as a new JLabel, and the JFrame is made visible and centered on the screen.
     */

    public interfaceBigParcel() {
        // RTTI
        System.out.println(getClass());

        setTitle("Package Delivery System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(7, 1));

        JLabel weightLabel = new JLabel("Enter package weight (in kg):");
        weightField = new JTextField(10);
        JPanel weightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        container.add(weightPanel);

        JLabel fragileLabel = new JLabel("Is the price of the package more than 10000$ ?");
        fragileYes = new JRadioButton("Yes");
        JRadioButton fragileNo = new JRadioButton("No");
        ButtonGroup fragileGroup = new ButtonGroup();
        fragileGroup.add(fragileYes);
        fragileGroup.add(fragileNo);
        JPanel fragilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fragilePanel.add(fragileLabel);
        fragilePanel.add(fragileYes);
        fragilePanel.add(fragileNo);
        container.add(fragilePanel);

        JLabel destinationLabel = new JLabel("Select destination:");
        String[] destinations = {"Europe", "North America", "Asia", "Australia", "Africa", "South America"};
        destinationBox = new JComboBox<>(destinations);
        JPanel destinationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        destinationPanel.add(destinationLabel);
        destinationPanel.add(destinationBox);
        container.add(destinationPanel);

        JLabel insuranceLabel = new JLabel("Add insurance:");
        insuranceCheckbox = new JCheckBox();
        JPanel insurancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        insurancePanel.add(insuranceLabel);
        insurancePanel.add(insuranceCheckbox);
        container.add(insurancePanel);

        JButton calculateButton = new JButton("Calculate Cost");
        calculateButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        container.add(buttonPanel);
        calculateButton.setForeground(new Color(238, 1, 18));
        calculateButton.setBackground(new Color(167, 251, 241));

        costLabel = new JLabel();
        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        costPanel.add(costLabel);
        container.add(costPanel);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**

     This method is called when the "Calculate Cost" button is clicked. It performs the necessary calculations
     and displays the shipping cost on the costLabel. If the package is fragile, it opens a new window for filling out wholesale information.
     @param e The ActionEvent object representing the event that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        double weight = Double.parseDouble(weightField.getText());
        boolean fragile = fragileYes.isSelected();
        int destinationIndex = destinationBox.getSelectedIndex();
        boolean insuranceSelected = insuranceCheckbox.isSelected();

        DeliveryOption deliveryOption;
        deliveryOption = new PrimeDelivery();

        Parcel parcel;
        if (weight <= 1) {
            parcel = new SmallParcel(weight, fragile);
        } else {
            parcel = new BigParcel(weight, fragile);
        }

        Destination destination;
        if (destinationIndex == 0) {
            destination = new EuropeDestination();
        } else if (destinationIndex == 1) {
            destination = new NorthAmerica();
        } else if (destinationIndex == 2) {
            destination = new AsiaDestination();
        } else if (destinationIndex == 3) {
            destination = new Australia();
        } else if (destinationIndex == 4) {
            destination = new Africa();
        } else {
            destination = new SouthAmerica();
        }

        double cost = deliveryOption.calculateCost(parcel, destination);

        if (insuranceSelected) {
            cost += 10.0; // Add insurance cost to the total cost
        }

        costLabel.setText(String.format("Shipping cost: $%.2f", cost));

        if(fragile){
            dispose();
            WholeSale actionWindow2 = new WholeSale();
            actionWindow2.setVisible(true);
        }
    }
}