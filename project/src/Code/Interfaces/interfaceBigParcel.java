package Code.Interfaces;

import Code.Delivery.DeliveryOption;
import Code.Delivery.PrimeDelivery;
import Code.Delivery.StandartDelivery;
import Code.Destinations.AmericaDestination;
import Code.Destinations.AsiaDestination;
import Code.Destinations.Destination;
import Code.Destinations.EuropeDestination;
import Code.Parcel.BigParcel;
import Code.Parcel.Parcel;
import Code.Parcel.SmallParcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaceBigParcel extends JFrame implements ActionListener, exceptionInterface {

        private final JLabel costLabel;
        private final JTextField weightField;
        private final JComboBox<String> optionBox;
        private final JComboBox<String> destinationBox;
        private final JRadioButton fragileYes;

        public interfaceBigParcel() {
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
            if (optionBox.getSelectedIndex() == 0) {
                deliveryOption = new StandartDelivery();
            } else {
                deliveryOption = new PrimeDelivery();
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
                destination = new AmericaDestination();
            } else {
                destination = new AsiaDestination();
            }

            double cost = deliveryOption.calculateCost(parcel, destination);
            costLabel.setText(String.format("Shipping cost: $%.2f", cost));
        }
    }

