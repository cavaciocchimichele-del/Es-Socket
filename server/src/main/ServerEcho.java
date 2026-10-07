import java.io.*;
import java.net.*;

public class ServerEcho {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server in ascolto sulla porta 5000...");

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String messaggio;
                while ((messaggio = in.readLine()) != null) {
                    if (messaggio.equalsIgnoreCase("exit")) {
                        out.println("EXIT");
                        break;
                    }
                    out.println(messaggio.toUpperCase());
                }
            }
            System.out.println("Server terminato.");
        }
    }
}
