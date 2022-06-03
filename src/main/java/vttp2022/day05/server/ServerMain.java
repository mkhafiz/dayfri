package vttp2022.day05.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
 
    public static void main(String[] args) 
        throws IOException {

        //Cretae a server socket + listen to a port
        ServerSocket server = new ServerSocket(3000);
        
        System.out.println("Waiting for connection on port 3000...");
        //Wait for incoming client connection
        Socket sock = server.accept();
        System.out.println("Server connected"); 

        //Get input and outpt stream -bytes
        //Get input stream
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        //Get otput stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        //Read request from client
        String request = dis.readUTF();

        //perform operation on request
        request = request.toUpperCase();
        
        //write back data to client
        dos.writeUTF(request);

    }
}
