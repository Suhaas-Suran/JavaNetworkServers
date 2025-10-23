package MultiThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                try (Socket socket = new Socket(address, port);
                     PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    toServer.println("Hello World from client " + socket.getLocalSocketAddress());
                    String response = fromServer.readLine();
                    System.out.println("Server says: " + response);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        for (int i = 0; i < 100; i++) {
            new Thread(client.getRunnable()).start();
        }
    }
}
