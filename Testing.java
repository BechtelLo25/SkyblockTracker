import javax.swing.*;
import java.awt.*;

public class Testing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Formatted JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        // GridLayout parameters: rows, columns, horizontal gap, vertical gap

        // Create components for the top row
        JLabel label1 = new JLabel("Label 1:");
        JLabel label2 = new JLabel("Label 2:");
        JButton button = new JButton("Button");

        // Create a text box for the bottom row
        JTextField textBox = new JTextField();

        // Add components to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(button);
        panel.add(textBox);

        // Add the panel to the content pane of the frame
        frame.getContentPane().add(panel);

        // Set the size of the frame
        frame.setSize(300, 150);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}