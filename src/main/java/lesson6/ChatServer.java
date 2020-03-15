package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread{
    private Chat chat;
    public static final String END_COMMAND = "/end";
    private Socket clientSocket = null;
    public boolean sendMessage(String message){
        if (clientSocket == null) return false;
        if (message == null) return false;
        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF(" Сообщение от сервера: " + message);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public  void run()  {


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8188, 1);
            System.out.println("Сервер запущен, ожидаем подключения...");
            boolean flag = true;
            while (flag) {
                clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");

                chat.AddToChatUsersArea(clientSocket.getLocalAddress().getHostAddress());
                flag = false;
            }
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("From client: " + message);
                if (message.equals(END_COMMAND)) {
                    break;
                }
                out.writeUTF(clientSocket.getLocalAddress().getHostAddress()+": " + message);
                chat.AddToChatArea(clientSocket.getLocalAddress().getHostAddress()+":");
                chat.AddToChatArea(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
