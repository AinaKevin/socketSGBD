// a java program for a CLientSide
import java.net.*;
import java.util.Vector;
import java.io.*;
public class Client
{
    //initialize socket and inpt output streams
    private Socket socket = null;
    private DataInputStream input = new DataInputStream(System.in);
    ObjectInputStream  objet ;
    private DataOutputStream out = null;

    //constructor to put ip adress and port
    public Client(String address , int port)
    {    //estabilish a connection
        Vector<String> vect = new Vector<>();
        try {
             socket = new Socket(address,port);
            System.out.println("Connected");
            //take input from terminal
             input = new DataInputStream(System.in);
            //send output to the socket
             out = new DataOutputStream(socket.getOutputStream()); 
            
            } catch (Exception o) {
            System.out.println(o);
        }
        // string to read message from input
        String line="";
        //keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line =input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }
        //close the connection
        try {
            objet = new ObjectInputStream(socket.getInputStream());
            vect = (Vector<String>) objet.readObject();
            //System.out.println(vect.size());
            for (String string : vect) {
                System.out.println(string);
            }
            input.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1",9999); // "127.0.0.1" idconfig par defaut ana ordi  
    }
}