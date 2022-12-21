//A java program for a Serverside
import java.net.*;
import java.util.Vector;
import java.io.*;
public class Server
{
    //initialize socket and input stream 
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private ObjectOutputStream out = null;
    //constructor with port 
    public Server(int port) throws Exception
    {
        Vector<String> vect = new Vector<>();
        //start server and wait fro the connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server starded");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
            // take input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = " ";
            //read message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    String[] resultat = line.split(" ");
                    System.out.println(line);
                     if( resultat[0].equals("Select") && resultat[2].equals("from"))
                      {vect = Sjbd.select(line);}
                      if (resultat[0].equals("insert")){
                        {vect = Sjbd.insert(line);}
                      }
                    }
                 catch (IOException i) {
                    System.out.println(i);
                }
            }
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(vect);
            // System.out.println("closing connection");
            // //close connection
            // socket.close();
            // in.close();
        } catch (IOException i) {
                System.out.println(i);
        }
    }
    public static void main(String[] args) throws Exception {
        Server server = new Server(9999);
    }
}