import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Text Box App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text field
        JTextField textField = new JTextField(20);

        // Create a button
        JButton runButton = new JButton("Run");

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field and print it
                String text = textField.getText();
                System.out.println("Text from text box: " + text);
            }
        });

        // Create a panel and add components to it
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(runButton);

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