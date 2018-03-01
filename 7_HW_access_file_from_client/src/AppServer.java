import java.net.*;
import java.io.*;

/// File IO module
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
                readFileA();
                // Acces file from client
                if (myReadData == "read FileA"){
                    System.out.println("dumpass");
                    readFileA();
                }
                else if(myReadData == "read FileB"){
                    readFileB();
                }
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
    // RETURN STRING METHOD
    public void readFileA(){
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/7_HW_access_file_from_client/FileA.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;

            DataOutputStream myDataOutputStream = new DataOutputStream(this._socket.getOutputStream());

            while ((line = reader.readLine()) != null) {
                myDataOutputStream.writeUTF(line);
            }
            myDataOutputStream.flush();
            myDataOutputStream.close();
        } catch (IOException e) {
            System.err.println("IOExceprion: "+e.getMessage());
        }
    }
    public void readFileB(){
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/7_HW_access_file_from_client/FileB.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;

            DataOutputStream myDataOutputStream = new DataOutputStream(this._socket.getOutputStream());

            while ((line = reader.readLine()) != null) {
                myDataOutputStream.writeUTF(line);
            }
            myDataOutputStream.flush();
            myDataOutputStream.close();
        } catch (IOException e) {
            System.err.println("IOExceprion: "+e.getMessage());
        }
    }

}
