import java.io.*;
import java.net.*;

public class MyMainClient {
    public static void main(String[] args) throws Exception{
        System.out.printf("Client ---> Start! \n");

        Socket mySocket = new Socket("localhost", 3333);
//        Socket mySocket = new Socket("localhost", 3333);
        DataInputStream myDataInputStream = new DataInputStream(mySocket.getInputStream());
        DataOutputStream myDataOutputStream = new DataOutputStream(mySocket.getOutputStream());
        BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String myWriteData = "", myReadData = "";

        while (!myWriteData.equals("stop")){
            myWriteData = myBufferedReader.readLine();
            myDataOutputStream.writeUTF(myWriteData);
            myDataOutputStream.flush();
            myReadData = myDataInputStream.readUTF();
            System.out.println("Server says: "+ myReadData);
        }

        myDataOutputStream.close();
        mySocket.close();

        System.out.println("Client ---> Finish! \n");
    }
}
