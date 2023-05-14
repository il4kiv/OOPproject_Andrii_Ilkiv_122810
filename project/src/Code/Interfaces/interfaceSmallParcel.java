package Code.Interfaces;
import Code.Delivery.*;
import Code.Destinations.*;
import Code.Parcel.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Code.Delivery.DeliveryOption.createDeliveryOption;

/**
 This class represents a graphical user interface for a small parcel package delivery system.
 It provides the user with options to input the weight, delivery option, fragility, and destination
 of a package and calculates the shipping cost based on those inputs.
 */
public class interfaceSmallParcel extends JFrame implements ActionListener, exceptionInterface {

    protected final JLabel costLabel;
    protected final JTextField weightField;
    protected final JComboBox<String> optionBox;
    protected final JComboBox<String> destinationBox;
    protected final JRadioButton fragileYes;

    /**
     * Constructs a new interfaceSmallParcel object by setting the size, title, and layout of the JFrame container.
     * It also creates input fields for weight, delivery option, fragility, and destination, as well as a button to
     * calculate the shipping cost and a label to display the calculated cost.
     */
    public interfaceSmallParcel() {
        System.out.println(getClass());
        setTitle("Package Delivery System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(6, 1));

        JLabel weightLabel = new JLabel("Enter package weight (in kg):");
        weightField = new JTextField(10);
        JPanel weightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        container.add(weightPanel);

        JLabel optionLabel = new JLabel("Select delivery option:");
        String[] options = {"Standard Delivery", "Prime Delivery"};
        optionBox = new JComboBox<>(options);
        JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        optionPanel.add(optionLabel);
        optionPanel.add(optionBox);
        container.add(optionPanel);

        JLabel fragileLabel = new JLabel("Is the package fragile?");
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

     Overrides the actionPerformed method of ActionListener interface to implement the calculation of shipping cost
     based on user inputs. It retrieves the weight, fragility, and destination inputs and creates new instances of the
     corresponding classes and interfaces to calculate the shipping cost based on the chosen delivery option.
     @param e The ActionEvent object representing the event triggered by the user clicking the "Calculate Cost" button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        double weight = Double.parseDouble(weightField.getText());
        boolean fragile = fragileYes.isSelected();
        int destinationIndex = destinationBox.getSelectedIndex();

        DeliveryOption deliveryOption;
        if (optionBox.getSelectedIndex() == 0) {
            if (weight > 100) {
                try {
                    throw new localException();
                } catch (localException ex) {
                    costLabel.setText(ex.getMessage());
                    costLabel.setForeground(Color.RED);
                    return;
                }
            }
            costLabel.setForeground(Color.BLACK);
            deliveryOption = createDeliveryOption("standart");
        } else {
            deliveryOption = createDeliveryOption("prime");
        }

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
        costLabel.setText(String.format("Shipping cost: $%.2f", cost));
    }
}