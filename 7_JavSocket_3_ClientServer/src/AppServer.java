import java.net.*;
import java.io.*;

public class AppServer extends Thread {
    // Class member ---
    Socket _socket;

    public AppServer(Socket socket) throws IOException {
        this._socket = socket;
    }

    public void run() {
        try {
            System.out.printf("App Server ---> Start! \n");

            DataInputStream myDataInputStream = new DataInputStream(this._socket.getInputStream());
            DataOutputStream myDataOutputStream = new DataOutputStream(this._socket.getOutputStream());
            BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String myReadData = "", myWriteData = "";

            while(!myWriteData.equals("stop")) {
                myWriteData = myBufferedReader.readLine();
                myDataOutputStream.writeUTF(myWriteData);
                myDataOutputStream.flush();
                myReadData = myDataInputStream.readUTF();
                System.out.println(this._socket.getRemoteSocketAddress()+" says: " + myReadData);
            }

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
}
