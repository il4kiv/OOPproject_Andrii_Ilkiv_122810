package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackageDeliverySystem extends JFrame implements ActionListener {

    private final JLabel costLabel;
    private final JTextField weightField;
    private final JComboBox<String> optionBox;
    private final JComboBox<String> destinationBox;
    private final JRadioButton fragileYes;

    public PackageDeliverySystem(){

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
        weightLabel.setBounds(100, 100,100,100);

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
        String[] destinations = {"Europe", "America", "Asia"};
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

    @Override
    public void actionPerformed(ActionEvent e) {
        double weight = Double.parseDouble(weightField.getText());
        boolean fragile = fragileYes.isSelected();
        int destinationIndex = destinationBox.getSelectedIndex();

        DeliveryOption deliveryOption;
        if (weight > 100 && optionBox.getSelectedIndex() == 0) {
            deliveryOption = new PrimeDelivery();
            JOptionPane.showMessageDialog(null, "You can use only Prime Delivery if weight is more than 100kg");
        } else if (optionBox.getSelectedIndex() == 0) {
            deliveryOption = new StandardDelivery();
        } else {
            deliveryOption = new PrimeDelivery();
        }

        Destination destination;
        if (destinationIndex == 0) {
            destination = new EuropeDestination();
        } else if (destinationIndex == 1) {
            destination = new AmericaDestination();
        } else {
            destination = new AsiaDestination();
        }

        double cost = deliveryOption.calculateCost(weight, fragile, destination);
        costLabel.setText(String.format("Shipping cost: $%.2f", cost));
    }
}

abstract class DeliveryOption {
    public abstract double calculateCost(double weight, boolean fragile, Destination destination);
}

class StandardDelivery extends DeliveryOption{
    @Override
    public double calculateCost(double weight, boolean fragile, Destination destination) {
        double baseCost = 0.0;
        if (destination instanceof EuropeDestination) {
            baseCost = 25;
        } else if (destination instanceof AmericaDestination) {
            baseCost = 30;
        } else if (destination instanceof AsiaDestination){
            baseCost = 10;
        }
        double cost = baseCost + 10 * weight;
        if (fragile) {
            cost += 10;
        }
        return cost;
    }
}

// cena zasielky
class PrimeDelivery extends DeliveryOption {
    @Override
    public double calculateCost(double weight, boolean fragile, Destination destination) {
        double baseCost = 0.0;
        if (destination instanceof EuropeDestination) {
            baseCost = 30;
        } else if (destination instanceof AmericaDestination) {
            baseCost = 35;
        } else if (destination instanceof AsiaDestination){
            baseCost = 15;
        }
        double cost = baseCost + 10 * weight;
        if (fragile) {
            cost += 10;
        }
        return cost;
    }
}

abstract class Destination {}
class EuropeDestination extends Destination {}

class AmericaDestination extends Destination {}

class AsiaDestination extends Destination {}