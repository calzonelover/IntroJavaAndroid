import java.io.*;
import java.net.*;

public class MyMainServer{
    public static void main(String[] args) {
        System.out.printf("Server ---> Start ! \n");
        try {
            ServerSocket myServerSocket = new ServerSocket(6666);
            System.out.printf("Server ---> Waiting for connection! \n");
            Socket mySocket = myServerSocket.accept(); // wait until got signal
            DataInputStream myDataInputStream = new DataInputStream(mySocket.getInputStream()); // get data stream
            String myReadData = (String)myDataInputStream.readUTF(); // Decode input stream by UTF and convert to String
            System.out.println("Message = "+myReadData);
            DataInputStream myDataInputStream2 = new DataInputStream(mySocket.getInputStream());///
            String myReadData2 = (String)myDataInputStream2.readUTF(); ///
            System.out.println("Message = "+myReadData2);///
            myServerSocket.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.printf("Server ---> Finish ! \n");
    }
}