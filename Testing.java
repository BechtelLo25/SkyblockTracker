import javax.swing.*;

public class Testing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Positioned Component Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager to null for absolute positioning
        frame.setLayout(null);

        // Create a text field
        JTextField textField = new JTextField();
        // Set the position and size of the text field
        textField.setBounds(150, 100, 150, 25);

        // Add the text field to the frame
        frame.add(textField);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}