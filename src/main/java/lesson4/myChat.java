package lesson4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myChat {
    private JPanel panel1;
    private JTextField testInput;
    private JButton Ok;
    private JList<String> chatList;
    private JList<String> userList;

    public myChat() {
        DefaultListModel<String> chatListModel = new DefaultListModel<>();
        chatList.setModel(chatListModel);
        DefaultListModel<String> userListModel = new DefaultListModel<>();
        userList.setModel(userListModel);
        userListModel.addElement("~DivanJeeper~");
        userListModel.addElement("ГлавБух");
        userListModel.addElement("Прапор");




        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    String textInputString = testInput.getText();
                    String selectedValue = "@" + userList.getSelectedValue() + ":";
                    testInput.setText(selectedValue + " " + textInputString);
                    selectedValue = "";
                    textInputString = "";
                }
            }
        });



        Ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = testInput.getText();
                if (!inputText.isEmpty()) chatListModel.addElement(testInput.getText());
                testInput.setText("");
            }
        });

        testInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatListModel.addElement(testInput.getText());
                testInput.setText("");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setContentPane(new myChat().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

    }
}
