import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static SkyblockTracker skyblockTracker = new SkyblockTracker();
    public static void main(String[] args) {

        createAndShowJframe();

    }

    private static void createAndShowJframe() {
        JFrame frame = new JFrame("Logan's Auction Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                GradientPaint gradient = new GradientPaint(100, 100, new Color(0, 120, 0), getWidth(), getHeight(), new Color(150, 255, 150));

                ((Graphics2D) g).setPaint(gradient);

                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };;

        String[] items = {"Select Player", "LoganMC618", "Ktf_Party"};

        // Initializing JFrame Components
        JTextArea playerSelect = new JTextArea();
        JTextArea textArea = new JTextArea();
        JButton runButton = new JButton("Run");

        playerSelect.append("Insert MC Username");
        textArea.append("Welcome to Logan's skyblock tracker! Select a player to track.");

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    textArea.setText("");
                    skyblockTracker.playerID = skyblockTracker.getUuid(playerSelect.getText());
                    textArea.append(playerSelect.getText() + " selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    textArea.append("Ten Mose Recent Auctions: \n\n");
                    textArea.append(skyblockTracker.getTenAuctions());
                
            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(playerSelect);
        panel.add(playerSelect);
        panel.add(textArea);
        
        panel.add(runButton);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(customFont);
        textArea.setBorder(new LineBorder(Color.WHITE, 2));
        playerSelect.setBackground(Color.DARK_GRAY);
        playerSelect.setForeground(Color.WHITE);
        playerSelect.setFont(customFont);
        playerSelect.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);
    }
}