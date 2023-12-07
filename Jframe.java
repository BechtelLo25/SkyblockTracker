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

    static AuctionTracker skyblockTracker = new AuctionTracker();
    static LowestBinTracker lowestBinTracker = new LowestBinTracker();
    static PriceHistoryTracker priceHistoryTracker = new PriceHistoryTracker();

    JFrame frame = new JFrame("Logan's Skyblock Auction Tracker");
    
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            GradientPaint gradient = new GradientPaint(100, 100, new Color(0, 120, 0), getWidth(), getHeight(), new Color(150, 255, 150));

            ((Graphics2D) g).setPaint(gradient);

            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };;

        public Jframe() {
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);

        }

        // Initializing JFrame Components
        JTextArea input = new JTextArea();
        JTextArea output = new JTextArea();
        JButton runButton = new JButton(" Run ");
        JButton backButton = new JButton(" Back ");
    
    public void createAuctionTrackerJframe() {
            
        input.setText("");
        output.setText("");
        
        input.append("Insert MC Username");
        output.append("Welcome to Logan's skyblock tracker! Select a player to track.");

        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the mouse event occurred within the JTextArea
                if (input.getBounds().contains(e.getPoint())) {
                    input.setText("");
                }
            }
        });

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    output.setText("");
                    skyblockTracker.playerID = skyblockTracker.getUuid(input.getText());
                    output.append(input.getText() + " selected!\n\nPlayer Uuid: " + skyblockTracker.playerID + "\n\n");
                    output.append("Ten Mose Recent Auctions: \n\n");
                    output.append(skyblockTracker.getTenAuctions());
                
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.main(null);
                frame.dispose();

            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        Font backButtonFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(input);
        panel.add(input);
        panel.add(output);
        panel.add(runButton);
        panel.add(backButton);
        output.setBackground(Color.DARK_GRAY);
        output.setForeground(Color.WHITE);
        output.setFont(customFont);
        output.setBorder(new LineBorder(Color.WHITE, 4));
        output.setEditable(false);
        input.setBackground(Color.DARK_GRAY);
        input.setForeground(Color.WHITE);
        input.setFont(customFont);
        input.setBorder(new LineBorder(Color.WHITE, 2));
        runButton.setBackground(Color.DARK_GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setFont(customFont);
        runButton.setBorder(new LineBorder(Color.WHITE, 2));
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(backButtonFont);
        backButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);
    }

    public void createLowestBinJframe() {

        input.setText("");
        output.setText("");

        input.append("Insert Item Name");
        output.append("Welcome to Logan's Lowest Bin Tracker! Select an Item to Track.");

        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (input.getBounds().contains(e.getPoint())) {
                    input.setText("");
                }
            }
        });

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    output.setText("");
                    lowestBinTracker.itemID = lowestBinTracker.getItemID(input.getText());
                    output.append(input.getText() + " selected!\n\nItem ID: " + lowestBinTracker.itemID + "\n\n");
                    output.append("Lowest Bin: \n\n");
                    output.append(lowestBinTracker.getLowestBin() + "\n\n");
                    output.append("Second Lowest Bin: \n\n");
                    output.append(lowestBinTracker.getSecondLowestBin());
                
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.main(null);
                frame.dispose();

            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(input);
        panel.add(input);
        panel.add(output);
        panel.add(runButton);
        panel.add(backButton);
        output.setBackground(Color.DARK_GRAY);
        output.setForeground(Color.WHITE);
        output.setFont(customFont);
        output.setBorder(new LineBorder(Color.WHITE, 4));
        output.setEditable(false);
        input.setBackground(Color.DARK_GRAY);
        input.setForeground(Color.WHITE);
        input.setFont(customFont);
        input.setBorder(new LineBorder(Color.WHITE, 2));
        runButton.setBackground(Color.DARK_GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setFont(customFont);
        runButton.setBorder(new LineBorder(Color.WHITE, 2));
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(customFont);
        backButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);

    }

    public void createPriceHistoryJframe() {

        input.setText("");
        output.setText("");

        input.append("Insert Item Name");
        output.append("Welcome to Logan's Price History Tracker! Select an Item to Track.");

        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (input.getBounds().contains(e.getPoint())) {
                    input.setText("");
                }
            }
        });

        // Add action listener to the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    output.setText("");
                    priceHistoryTracker.itemID = priceHistoryTracker.getItemID(input.getText());
                    output.append(input.getText() + " selected!\n\nItem ID: " + priceHistoryTracker.itemID + "\n\n");
                    output.append(priceHistoryTracker.getPriceHistory());
                
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.main(null);
                frame.dispose();

            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);
        
        // Add and set everything
        panel.add(input);
        panel.add(input);
        panel.add(input);
        panel.add(runButton);
        panel.add(backButton, BorderLayout.SOUTH);
        output.setBackground(Color.DARK_GRAY);
        output.setForeground(Color.WHITE);
        output.setFont(customFont);
        output.setBorder(new LineBorder(Color.WHITE, 4));
        output.setEditable(false);
        input.setBackground(Color.DARK_GRAY);
        input.setForeground(Color.WHITE);
        input.setFont(customFont);
        input.setBorder(new LineBorder(Color.WHITE, 2));
        runButton.setBackground(Color.DARK_GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setFont(customFont);
        runButton.setBorder(new LineBorder(Color.WHITE, 2));
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(customFont);
        backButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setVisible(true);
    }
}

