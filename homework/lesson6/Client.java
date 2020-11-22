package homework.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static final String IP_ADDRESS = "localhost";
    private static Socket socket;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {
        try{
            socket = new Socket(IP_ADDRESS, PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e){
            e.printStackTrace();
        }
        connect();
    }

    private static void connect() {
        // thread send message
        new Thread(()->{
            while (true){
                Scanner scanner = new Scanner(System.in);
                String strToSend = scanner.nextLine();

                try {
                    outputStream.writeUTF(strToSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // thread receive message
        new Thread(()->{
            try {
                while(true){
                    String strFromServer = inputStream.readUTF();
                    if (strFromServer.equalsIgnoreCase("/end")) {
                        System.out.println("Сервер закрыл соединение!");
                        break;
                    }
                    System.out.println("From server: " + strFromServer);
                 }
            }catch (IOException e) {
                System.out.println("Соединение закрыто!");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
