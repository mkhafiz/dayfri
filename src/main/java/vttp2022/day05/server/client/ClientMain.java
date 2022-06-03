package vttp2022.day05.server.client;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) throws IOException {

        String input = " ";
        boolean run = true;

        System.out.println("Connecting to localhost...");
        // Connect to the server
        // eg 127.0.0.1 = local host (My comp)

        Socket sock = new Socket("127.0.0.1", 3000);
        System.out.println("Connected...");

        // Get input and outpt stream -bytes
        // Get input stream
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        // Get otput stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        while (run) {

            // Get input from user
            Console cons = System.console();
            input = cons.readLine("Say something ");

            // write to server
            dos.writeUTF(input);
            dos.flush(); //

            if (input.contains("exit")) {
                run = false;
                // close stream
                is.close();
                os.close();

                // close socket
                sock.close();

            } else {

                // wait for response from server
                String response = dis.readUTF();
                System.out.printf(">>> %s\n", response);

                /*
                 * //close stream
                 * is.close();
                 * os.close();
                 * 
                 * // close socket
                 * sock.close();
                 */
            }

        }
    }

}
