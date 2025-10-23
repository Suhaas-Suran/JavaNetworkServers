package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {

    // Handles each client
    public void handleClient(Socket clientSocket) {
        try (PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)) {
            toClient.println("Hello from server!");
            System.out.println("Responded to client: " + clientSocket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(10000); // 10 seconds
            System.out.println("Server started on port " + port);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    // Start a new thread to handle the client
                    new Thread(() -> handleClient(clientSocket)).start();
                } catch (SocketTimeoutException e) {
                    System.out.println("No client connected within 10 seconds. Server is stopping...");
                    break; // exit the loop after timeout
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server closed.");
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        server.run(port);
    }
}
