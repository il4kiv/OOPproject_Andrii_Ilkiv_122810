package Code.Interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackageSizeDeterminer extends JFrame implements ActionListener, exceptionInterface {

    private final JTextField heightField;
    private final JTextField widthField;
    private final JTextField lengthField;
    private final JButton determineButton;
    private final JLabel sizeLabel;
    private final JProgressBar progressBar;

    public PackageSizeDeterminer() {
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

        determineButton = new JButton("Determine Size");
        determineButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(determineButton);
        container.add(buttonPanel);


        progressBar = new JProgressBar();
        JPanel progressBarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        progressBarPanel.add(progressBar);
        container.add(progressBarPanel);

        sizeLabel = new JLabel();
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sizePanel.add(sizeLabel);
        container.add(sizePanel);

        setVisible(true);
        setLocationRelativeTo(null);
    }
        /////////////////  multithreading under
        @Override
        public void actionPerformed(ActionEvent e) {
        if (heightField.getText().isEmpty() || widthField.getText().isEmpty() || lengthField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter full size!");
            return;
        }
            // RTTI
            System.out.println(getClass());

        double height = Double.parseDouble(heightField.getText());
        double width = Double.parseDouble(widthField.getText());
        double length = Double.parseDouble(lengthField.getText());


        // Creating a SwingWorker to perform the computation in the background thread
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