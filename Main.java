import java.awt.Dimension;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static String playerID;
    public static String loganMC618PlayerUuid = "ccf6bfb290e142f591722f1a1a69133b";
    public static String ktf_PartyPlayerUuid = "0a8cd993831c45838569a160aeb1a44e";

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Logan's Auction Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Create a String array for dropdown items
        String[] items = {"Select Player", "LoganMC618", "Ktf_Party"};

        // Create a JComboBox (dropdown)
        JComboBox<String> dropdown = new JComboBox<>(items);
        JTextArea textArea = new JTextArea();
        
        // Add an ActionListener to the dropdown
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if "Item 1" is selected
                if ("LoganMC618".equals(dropdown.getSelectedItem())) {
                    textArea.setText("");
                    playerID = loganMC618PlayerUuid;
                    textArea.append("Logan selected!\nPlayer Uuid: " + playerID + "\n");
                    textArea.append(getTenAuctions());
                }
                else {
                    textArea.setText("");
                    playerID = ktf_PartyPlayerUuid;
                    textArea.append("Zack selected!\nPlayer Uuid: " + playerID + "\n");
                    textArea.append(getTenAuctions());  
                }
            }
        });

        // Add the dropdown and textbox to the panel
        panel.add(dropdown);
        panel.add(textArea);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static String getTenAuctions() {
        String apiUrl = "https://sky.coflnet.com/api/player/" + playerID + "/auctions?page=0&=string&=string&=string";

        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();
    
            // Create an HttpRequest with method GET and headers
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String firstAuction = "Last Auction: " + (response.body().substring(response.body().indexOf("itemName") + 11, response.body().indexOf("tag") - 3));
            return firstAuction;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Connect to wifi dummy";
    }
}