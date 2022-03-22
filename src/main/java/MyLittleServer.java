import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyLittleServer {

    private final static int PORT = 8080;

    public static void main(String[] args) {
        //сервер
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientServerSocket = serverSocket.accept();
             PrintWriter outSrv = new PrintWriter(clientServerSocket.getOutputStream(), true);
             BufferedReader inSrv = new BufferedReader(new InputStreamReader(clientServerSocket.getInputStream()))) {
            System.out.println("New connection accepted");
            final String name = inSrv.readLine();
            outSrv.println(String.format("Hi %s, your port is %d", name, clientServerSocket.getPort()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
