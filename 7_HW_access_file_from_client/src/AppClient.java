import java.io.*;
import java.net.Socket;

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

            String myWriteData = null, myReadData = null;

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

                // check command read
                checkRead(myDataInputStream, myWriteData);

            }

            myDataOutputStream.close();
            this._socket.close();

            System.out.printf("App Client ---> Finish! \n");
            System.out.printf("================== \n" +
                    "           1) read FileA \n" +
                    "           2) read FileB \n" +
                    "           3) read FileC \n" +
                    "          ==================");
        }
        catch (IOException e) {
            System.out.println("App Client :: IOException : " + e.getMessage());
        }

    }

    // method checkRead
    public void checkRead(DataInputStream myDataInputStream, String myWriteData){
        String myReadData;
        myWriteData+="         ";
        try {
            if (myWriteData.substring(0, 9).equals("read File")) {
                while (!(myReadData = myDataInputStream.readUTF()).equals("done")) {
                    System.out.println("Server says: " + myReadData);
                }
            }
        }
        catch (IOException io){
            System.out.println(io);
        }
    }


}

