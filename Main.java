import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static String loganMC618PlayerUuid = "ccf6bfb290e142f591722f1a1a69133b";
    public static String ktf_PartyPlayerUuid = "0a8cd993831c45838569a160aeb1a44e";

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

                // Create a gradient from gray to black
                GradientPaint gradient = new GradientPaint(100, 100, new Color(70, 70, 70), getWidth(), getHeight(), Color.BLACK);

                // Set the gradient paint
                ((Graphics2D) g).setPaint(gradient);

                // Fill the panel with the gradient
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };;

        String[] items = {"Select Player", "LoganMC618", "Ktf_Party"};

        JComboBox<String> dropdown = new JComboBox<>(items);
        JTextArea textArea = new JTextArea();
        
        textArea.append("Welcome to Logan's skyblock tracker! Select a player to track.");
        
        // Dropdown
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if "Item 1" is selected
                if ("LoganMC618".equals(dropdown.getSelectedItem())) {
                    textArea.setText("");
                    skyblockTracker.playerID = loganMC618PlayerUuid;
                    textArea.append("Logan selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    textArea.append("Ten Mose Recent Auctions: \n\n");
                    textArea.append(skyblockTracker.getTenAuctions());
                }
                else if ("Ktf_Party".equals(dropdown.getSelectedItem())) {
                    textArea.setText("");
                    skyblockTracker.playerID = ktf_PartyPlayerUuid;
                    textArea.append("Zack selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    textArea.append("Ten Mose Recent Auctions: \n\n");
                    textArea.append(skyblockTracker.getTenAuctions());
                }
                else {
                    textArea.setText("No one is selected dummy");
                }
            }
        });

        Font customFont = new Font("Trebuchet MS", Font.PLAIN, 14);
        
        // Add and set everything
        panel.add(dropdown);
        panel.add(textArea);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(customFont);
        textArea.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);
    }
}