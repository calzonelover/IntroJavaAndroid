import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/// File IO module

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

            while(!myReadData.equals("stop")) {
                // check statement
                //myWriteData = myBufferedReader.readLine();
                //myDataOutputStream.writeUTF(myWriteData);
                //myDataOutputStream.flush();
                myReadData = myDataInputStream.readUTF();
                System.out.println(this._socket.getRemoteSocketAddress()+" says: " + myReadData);
                /// Acces file from client
                // Read File A
                if (myReadData.equals("read FileA")){
                    readFileA(myDataOutputStream);
                } // Read File B
                else if (myReadData.equals("read FileB")){
                    readFileB(myDataOutputStream);
                } //Read File C
                else if (myReadData.equals("read FileC")){
                    readFileC(myDataOutputStream);
                }
                // Exit
                else if (myReadData.equals("exit")){
                    break;
                }
            }
            myDataOutputStream.writeUTF("Bye");
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
    //// RETURN STRING METHOD
    public void readFileA(DataOutputStream myDataOutputStream){
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/7_HW_access_file_from_client/FileA.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;
            while ((line = reader.readLine()) != null) {
                myDataOutputStream.writeUTF("File A :"+line);
            }
            myDataOutputStream.writeUTF("done");
            myDataOutputStream.flush();
        } catch (IOException e){
            System.out.println("App Server :: IOException : " + e.getMessage());
        }
    }
    public void readFileB(DataOutputStream myDataOutputStream){
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/7_HW_access_file_from_client/FileB.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;
            while ((line = reader.readLine()) != null) {
                myDataOutputStream.writeUTF("File B :"+ line);
            }
            myDataOutputStream.writeUTF("done");
            myDataOutputStream.flush();
        } catch (IOException e){
            System.out.println("App Server :: IOException : " + e.getMessage());
        }
    }
    public void readFileC(DataOutputStream myDataOutputStream){
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/7_HW_access_file_from_client/FileC.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;
            while ((line = reader.readLine()) != null) {
                myDataOutputStream.writeUTF("File C :"+line);
            }
            myDataOutputStream.writeUTF("done");
            myDataOutputStream.flush();
        } catch (IOException e){
            System.out.println("App Server :: IOException : " + e.getMessage());
        }
    }

}
