import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    
    public void run() throws IOException {
        int port = 8010; // must match server
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        System.out.println("Connected to server: " + socket.getRemoteSocketAddress());

        PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toServer.println("Hello World from client " + socket.getLocalSocketAddress());

        String response = fromServer.readLine();
        System.out.println("Server says: " + response);

        socket.close();
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
