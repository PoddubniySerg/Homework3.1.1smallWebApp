import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

    private final static int PORT = 8080;
    private final static String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        //клиент
        Socket clientSocket = new Socket(HOST, PORT);
        PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outClient.println("Serg");
        System.out.println(inClient.readLine());
    }
}
