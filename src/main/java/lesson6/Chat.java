package lesson6;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Chat extends JFrame {
    private ChatServer chatServer = new ChatServer();
    private JTextField msgInputField;
    private JTextArea chatArea;
    private JTextArea chatUsers;

    public void AddToChatUsersArea(String text){
        chatUsers.append(text+"\n");
    }

    public void AddToChatArea(String text){
        chatArea.append(text+"\n");
    }

    public Chat(){
        prepareServerGUI();
    }

    private  void prepareServerGUI() {
        // Параметры окна
        setBounds(10, 10, 300, 300);
        setTitle("Сервер");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Текстовое поле для вывода сообщений
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        chatUsers = new JTextArea();
        chatUsers.setEditable(false);
        chatUsers.setLineWrap(true);
        add(new JScrollPane(chatUsers), BorderLayout.WEST);

        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(e -> sendMessage(msgInputField.getText()));

        msgInputField.addActionListener(e -> sendMessage(msgInputField.getText()));


        // Настраиваем действие на закрытие окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

        setVisible(true);

    }

    private void sendMessage(String message) {
       if ( chatServer.sendMessage(message)) chatArea.append(message+"\n");

        msgInputField.setText("");
    }

    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        chat.chatServer.start();
        chat.chatServer.setChat(chat);

        System.out.println("run away");

    }


}
