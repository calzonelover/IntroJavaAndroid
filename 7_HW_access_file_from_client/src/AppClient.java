import java.net.*;
import java.io.*;

public class AppClient {
    // Clsss member ---
    final String _REMOTE_IP = "localhost";
    final int _PORT_NO = 3000;
    private Socket _socket;

    public AppClient() throws Exception {
        // Connect to Server ---
        this._socket = new Socket(_REMOTE_IP, _PORT_NO);
    }

    public void CommunicateToServer() {
        try {
            System.out.printf("App Client ---> Start! \n");

            DataInputStream myDataInputStream = new DataInputStream(this._socket.getInputStream());
            DataOutputStream myDataOutputStream = new DataOutputStream(this._socket.getOutputStream());
            BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String myWriteData = "", myReadData = "";

            myWriteData = "Hello Server!!!";

            while(!myWriteData.equals("stop")) {
                myWriteData = myBufferedReader.readLine();
                // check Client exit or not
                if (myWriteData == "stop"){
                    System.out.printf("You already exit the server !");
                    break;
                }

                myDataOutputStream.writeUTF(myWriteData);
                myDataOutputStream.flush();

                myReadData = myDataInputStream.readUTF();
                System.out.println("Server says: " + myReadData);
            }

            myDataOutputStream.close();
            this._socket.close();

            System.out.printf("App Client ---> Finish! \n");
        }
        catch (IOException e) {
            System.out.println("App Client :: IOException : " + e.getMessage());
        }

    }


}

