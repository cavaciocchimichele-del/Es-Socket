import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientEcho {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner tastiera = new Scanner(System.in)) {

            while (true) {
                System.out.print("Scrivi una frase (exit per uscire): ");
                String frase = tastiera.nextLine();

                out.println(frase);
                System.out.println("Risposta dal Server: " + in.readLine());

                if (frase.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            System.out.println("Client terminato.");
        }
    }
}