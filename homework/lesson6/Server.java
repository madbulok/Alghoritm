package homework.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private final int PORT = 8189;
    private ServerSocket server = null;
    private Socket socket = null;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is running...");
            socket = server.accept();
            System.out.println("Client is connected!");

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // sender messages
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

        // receiver messages
        new Thread(()->{
            try{
                while (true){
                    String str = inputStream.readUTF();
                    if (str.equalsIgnoreCase("/end")) {
                        System.out.println("Клиент отключился!");
                        break;
                    }
                    System.out.println( "From client: " + str);
                }
            } catch (IOException e){
                System.out.println("Соединение закрыто!");
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (server != null) {
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
