import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000); // 10 seconds
        System.out.println("Server is listening on port: " + port);

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String messageFromClient = fromClient.readLine();
                System.out.println("Client says: " + messageFromClient);

                toClient.println("Hello from server!");
            } catch (SocketTimeoutException e) {
                System.out.println("No client connected within 10 seconds. Server is stopping...");
                break; // stop the server after timeout
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        serverSocket.close();
        System.out.println("Server closed.");
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
