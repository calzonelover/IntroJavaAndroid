import java.io.*;
import java.net.*;

public class MyMainServer {
    public static void main(String[] args) throws Exception{
        System.out.printf("Server ---> Start! \n");

        ServerSocket myServerSocket = new ServerSocket(3333);
        Socket mySocket = myServerSocket.accept();// wait until it got

        DataInputStream myDataInputStream = new DataInputStream(mySocket.getInputStream());
        DataOutputStream myDataOutputStream = new DataOutputStream(mySocket.getOutputStream());

        BufferedReader myBufferReader = new BufferedReader( new InputStreamReader((System.in)));

        String myReadData = "", myWriteData = "";

        while (!(myReadData.equals("stop") || myWriteData.equals("stop"))){
            myReadData = myDataInputStream.readUTF();
            System.out.println("client says: "+ myReadData);
            myWriteData = myBufferReader.readLine();
            myDataOutputStream.writeUTF(myWriteData);
            myDataOutputStream.flush();

        }

        myDataInputStream.close();
        mySocket.close();
        myServerSocket.close();

        System.out.println("Server ---> Finish ! \n");
    }
}
