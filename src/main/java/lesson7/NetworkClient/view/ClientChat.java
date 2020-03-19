package lesson7.NetworkClient.view;

import lesson7.NetworkClient.controller.ClientController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientChat extends JFrame {

    private JPanel mainPanel;
    private JList<String> usersList;
    private JTextField messageTextField;
    private JButton sendButton;
    private JTextArea chatText;

    private ClientController controller;

    public ClientChat(ClientController controller) {
        this.controller = controller;
        setTitle(controller.getUsername());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        addListeners();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
            }
        });
    }


    private void addListeners() {
        sendButton.addActionListener(e -> {
            ClientChat.this.sendMessage();
        });
        messageTextField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = messageTextField.getText().trim();
        String selectedUser =  usersList.getSelectedValue() ;
        usersList.clearSelection();
        if (message.isEmpty()) {
            return;
        }

        appendOwnMessage(message, selectedUser);
        if (selectedUser != null){
            /* /w nick3 message */
            message = "/w "+selectedUser+" "+message;
        }
        controller.sendMessage(message);
        messageTextField.setText(null);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            chatText.append(message);
            chatText.append(System.lineSeparator());
        });
    }


    private void appendOwnMessage(String message, String toUsername) {
        if (toUsername == null) {
            appendMessage("Я: " + message);
        }else{
            appendMessage("Я to "+toUsername+" : " + message);
        }
    }


}
