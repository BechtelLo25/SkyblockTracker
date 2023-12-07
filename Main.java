import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static TrackerJframes jframe = new TrackerJframes();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Logan's Skyblock Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton auctionButton = new JButton("Auction Tracker");
        JButton lowestBinButton = new JButton("Lowest Bin Tracker");
        JButton priceHistoryButton = new JButton("Price History Tracker");


        JPanel panel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            GradientPaint gradient = new GradientPaint(100, 100, new Color(0, 120, 0), getWidth(), getHeight(), new Color(150, 255, 150));

            ((Graphics2D) g).setPaint(gradient);

            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };;

        auctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.createAuctionTrackerJframe();
                frame.dispose();
            }
        });

        lowestBinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.createLowestBinJframe();
                frame.dispose();
            }
        });

        priceHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.createPriceHistoryJframe();
                frame.dispose();
            }
        });

        Font customFont = new Font("Trebuchet MS", Font.BOLD, 20);

        panel.add(auctionButton);
        panel.add(lowestBinButton);
        panel.add(priceHistoryButton);

        auctionButton.setBackground(Color.DARK_GRAY);
        auctionButton.setForeground(Color.WHITE);
        auctionButton.setFont(customFont);
        auctionButton.setBorder(new LineBorder(Color.WHITE, 2));
        lowestBinButton.setBackground(Color.DARK_GRAY);
        lowestBinButton.setForeground(Color.WHITE);
        lowestBinButton.setFont(customFont);
        lowestBinButton.setBorder(new LineBorder(Color.WHITE, 2));
        priceHistoryButton.setBackground(Color.DARK_GRAY);
        priceHistoryButton.setForeground(Color.WHITE);
        priceHistoryButton.setFont(customFont);
        priceHistoryButton.setBorder(new LineBorder(Color.WHITE, 2));
        frame.getContentPane().add(panel);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}