import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergencyTerminal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmergencyTerminal::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("911 Emergency Terminal");//sukuriamas naujas grafikos elemento rodmuo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//mygtukas programos isjungimui
        frame.setSize(400,300);//nustatomas lango dydis
        frame.setLayout(new BorderLayout());

        //struktura irasymo langams
        JPanel inputPanel = new JPanel(new GridLayout(4,2));

        //skambinancio vardo laukas
        inputPanel.add(new JLabel("Caller name:"));
        JTextField nameField = new JTextField();
        inputPanel.add((nameField));

        //skambinancio numerio laukas
        inputPanel.add(new JLabel("Phone Number"));
        JTextField phoneField = new JTextField();
        inputPanel.add(phoneField);

        //skubios pagalbos kategorija
        inputPanel.add(new JLabel("Emergency Type:"));
        JTextField typeField = new JTextField();
        inputPanel.add(typeField);

        //lokacijos laukas
        inputPanel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        inputPanel.add(locationField);

        //teksto laukas rodyti iskvietimu registra
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);//neleisti keisti registro irasu
        JScrollPane scrollPane = new JScrollPane(logArea);//pridedama slenkimo funkcija

        //uzregistruoti irasa
        JButton submitButton = new JButton("Log Emergency");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //irasu irasymo blokas
                String logEntry = "Caller: " + nameField.getText()+
                        "| Phone: " + phoneField.getText()+
                        "| Type: " + typeField.getText()+
                        "| Location: " + locationField.getText() + "\n";

                //prideti irasus i registra
                logArea.append(logEntry);

                //istrinti laukus po iraso irasymo
                nameField.setText("");
                phoneField.setText("");
                typeField.setText("");
                locationField.setText("");
            }
        });

        //pridedame elementus i grafika
        frame.add(inputPanel, BorderLayout.NORTH);//irasymo laukas virsuje
        frame.add(inputPanel, BorderLayout.CENTER);//irasymo laukas centre
        frame.add(buttonPanel, BorderLayout.SOUTH);//irasymo laukas apacioje

        //rodyti UX/UI
        frame.setVisible(true);

    }
}