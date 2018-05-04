package sample;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//date

/// File IO module

public class AppServer extends Thread {
    // Class member ---
    Socket _socket;
    public static List<Socket> listClient = new LinkedList<Socket>(); // List all client socket

    public AppServer(Socket socket) throws IOException {
        this._socket = socket;
        listClient.add(socket); // store all client socket
    }

    public void run() {
        try {
            System.out.printf("App Server ---> Start! \n");

            DataInputStream myDataInputStream = new DataInputStream(this._socket.getInputStream());
            DataOutputStream myDataOutputStream = new DataOutputStream(this._socket.getOutputStream());
            BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String myReadData = "", myWriteData = "";

            while(!myReadData.equals("stop")) {
                // check statement
                myReadData = myDataInputStream.readUTF();
                for (Socket clientSocket:listClient){
                    DataOutputStream clientDataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                    clientDataOutputStream.writeUTF(clientSocket.getRemoteSocketAddress()+": "+myReadData);
                    clientDataOutputStream.flush();
//                    System.out.println(clientSocket.getRemoteSocketAddress());// just for check
                }
                // print for check
                System.out.println(this._socket.getRemoteSocketAddress()+" says: " + myReadData);
            }
            myDataOutputStream.writeUTF("Good bye ");
            myDataOutputStream.flush();
            myDataOutputStream.close();
            this._socket.close();

            System.out.printf("App Server ---> Finish! \n");
        }
        catch (IOException e) {
            System.out.println("App Server :: IOException : " + e.getMessage());
        }
        finally {
            // do nothing ---
        }
    }
    // method
    public static String getCurrentDateTime() {
        Date todaysDate = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String todaysDate_str = formatter.format(todaysDate);
        return todaysDate_str;
    }

    public void broadcastMessage(String newMessage){
        for (Socket clientSocket: listClient) {
            try {
                DataOutputStream myDataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                myDataOutputStream.writeUTF(newMessage);
                myDataOutputStream.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
