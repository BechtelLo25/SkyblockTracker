import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static String loganMC618PlayerUuid = "ccf6bfb290e142f591722f1a1a69133b";
    public static String ktf_PartyPlayerUuid = "0a8cd993831c45838569a160aeb1a44e";

    static SkyblockTracker skyblockTracker = new SkyblockTracker();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Logan's Auction Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);

        JPanel panel = new JPanel();

        String[] items = {"Select Player", "LoganMC618", "Ktf_Party"};

        JComboBox<String> dropdown = new JComboBox<>(items);
        JTextArea textArea = new JTextArea();
        
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if "Item 1" is selected
                if ("LoganMC618".equals(dropdown.getSelectedItem())) {
                    textArea.setText("");
                    skyblockTracker.playerID = loganMC618PlayerUuid;
                    textArea.append("Logan selected!\nPlayer Uuid: " + skyblockTracker.playerID + "\n");
                    textArea.append(skyblockTracker.getTenAuctions());
                }
                else {
                    textArea.setText("");
                    skyblockTracker.playerID = ktf_PartyPlayerUuid;
                    textArea.append("Zack selected!\nPlayer Uuid: " + skyblockTracker.playerID + "\n");
                    textArea.append(skyblockTracker.getTenAuctions());
                }
            }
        });

        panel.add(dropdown);
        panel.add(textArea);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}