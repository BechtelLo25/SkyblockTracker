import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jframe {

    static SkyblockTracker skyblockTracker = new SkyblockTracker();
    
    public void createAuctionTrackerJframe() {
            
        JFrame frame = new JFrame("Logan's Skyblock Auction Tracker");
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

        // Initializing JFrame Components
        JTextArea playerSelect = new JTextArea();
        JTextArea auctionOutput = new JTextArea();
        JButton runButton = new JButton(" Run ");

        playerSelect.append("Insert MC Username");
        auctionOutput.append("Welcome to Logan's skyblock tracker! Select a player to track.");

        playerSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the mouse event occurred within the JTextArea
                if (playerSelect.getBounds().contains(e.getPoint())) {
                    playerSelect.setText("");
                }
            }
        });

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    auctionOutput.setText("");
                    skyblockTracker.playerID = skyblockTracker.getUuid(playerSelect.getText());
                    auctionOutput.append(playerSelect.getText() + " selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    auctionOutput.append("Ten Mose Recent Auctions: \n\n");
                    auctionOutput.append(skyblockTracker.getTenAuctions());
                
            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(playerSelect);
        panel.add(playerSelect);
        panel.add(auctionOutput);
        panel.add(runButton);
        auctionOutput.setBackground(Color.DARK_GRAY);
        auctionOutput.setForeground(Color.WHITE);
        auctionOutput.setFont(customFont);
        auctionOutput.setBorder(new LineBorder(Color.WHITE, 2));
        playerSelect.setBackground(Color.DARK_GRAY);
        playerSelect.setForeground(Color.WHITE);
        playerSelect.setFont(customFont);
        playerSelect.setBorder(new LineBorder(Color.WHITE, 2));
        runButton.setBackground(Color.DARK_GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setFont(customFont);
        runButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);
    }

    public void createLowestBinJframe() {

        JFrame frame = new JFrame("Logan's Skyblock Lowest Bin Tracker");
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

        // Initializing JFrame Components
        JTextArea itemSelect = new JTextArea();
        JTextArea itemOutput = new JTextArea();
        JButton runButton = new JButton(" Run ");

        itemSelect.append("Insert Item Name");
        itemOutput.append("Welcome to Logan's Lowest Bin Tracker! Select an Item to Track.");

        itemSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the mouse event occurred within the JTextArea
                if (itemSelect.getBounds().contains(e.getPoint())) {
                    itemSelect.setText("");
                }
            }
        });

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    itemOutput.setText("");
                    skyblockTracker.playerID = skyblockTracker.getUuid(itemSelect.getText());
                    itemOutput.append(itemSelect.getText() + " selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    itemOutput.append("Ten Mose Recent Auctions: \n\n");
                    itemOutput.append(skyblockTracker.getTenAuctions());
                
            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(itemSelect);
        panel.add(itemSelect);
        panel.add(itemOutput);
        panel.add(runButton);
        itemOutput.setBackground(Color.DARK_GRAY);
        itemOutput.setForeground(Color.WHITE);
        itemOutput.setFont(customFont);
        itemOutput.setBorder(new LineBorder(Color.WHITE, 2));
        itemSelect.setBackground(Color.DARK_GRAY);
        itemSelect.setForeground(Color.WHITE);
        itemSelect.setFont(customFont);
        itemSelect.setBorder(new LineBorder(Color.WHITE, 2));
        runButton.setBackground(Color.DARK_GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setFont(customFont);
        runButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);

    }
}
