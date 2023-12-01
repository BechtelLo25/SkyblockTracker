import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ahjwefiuhjaeif {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Dropdown Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a custom panel with a gradient background
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Create a gradient from gray to black
                GradientPaint gradient = new GradientPaint(0, 0, Color.GRAY, getWidth(), getHeight(), Color.BLACK);

                // Set the gradient paint
                ((Graphics2D) g).setPaint(gradient);

                // Fill the panel with the gradient
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Create a JPanel to hold components
        JPanel panel = new JPanel(new BorderLayout());

        // Create a String array for dropdown items
        String[] items = {"Item 1", "Item 2", "Item 3"};

        // Create a JComboBox (dropdown)
        JComboBox<String> dropdown = new JComboBox<>(items);

        // Create a JTextArea with multiple rows
        JTextArea textArea = new JTextArea();
        textArea.setRows(5); // Set the number of rows

        // Set the background color of the text area to match the gradient panel
        textArea.setBackground(new Color(40, 40, 40));
        textArea.setForeground(Color.WHITE); // Set text color to white

        // Set the font of the text area to Trebuchet MS
        Font trebuchetMSFont = new Font("Trebuchet MS", Font.PLAIN, 14); // You can customize the size
        textArea.setFont(trebuchetMSFont);

        // Set a black border around the text area
        textArea.setBorder(new LineBorder(Color.BLACK));

        // Add an ActionListener to the dropdown
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if "Item 1" is selected
                if ("Item 1".equals(dropdown.getSelectedItem())) {
                    // Set the text in the JTextArea to "Hi"
                    textArea.setText("Hiiiiiiiiiiiiiiiiiii");
                }
            }
        });

        // Add the dropdown and text area to the gradient panel
        gradientPanel.add(dropdown, BorderLayout.NORTH);
        gradientPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add the gradient panel to the main panel
        panel.add(gradientPanel);

        // Set the content pane of the frame
        frame.setContentPane(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}