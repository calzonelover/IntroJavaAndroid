import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;

public class MyMainClient {
    public static void main(String[] args){
        System.out.printf("Client ---> Start ! \n");
        try {
            Socket mySocket = new Socket("localhost", 6666);
            DataOutputStream myDataOutputStream = new DataOutputStream(mySocket.getOutputStream());
            myDataOutputStream.writeUTF("Halo im Jab !");
            myDataOutputStream.flush();// flush stream data to host that we want
            myDataOutputStream.close();
            mySocket.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Client ---> Finish ! \n");
    }
}