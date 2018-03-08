import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//date
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                } // Exit
                else if (myReadData.equals("exit")){
                    break;
                }
                /// Letter
                checkLetter(myDataOutputStream, myReadData);
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
    public void checkLetter(DataOutputStream myDataOutputStream, String myReadData){
        Inbox myInbox = new Inbox();
        List<String> myLines = new LinkedList<String>();
        myReadData+="             ";
        try {
            /// Write letter
            if (myReadData.substring(0, 6).equals("letter")) {// need to have "letter/to/from/content"
                /// split
                String[] output = myReadData.split("/");
                InboxData myInboxData = new InboxData(output[1], output[2],
                        output[3], "F", getCurrentDateTime());
                String myWriteLine = myInboxData.ComposeLine(myInboxData);
                myLines.add(myWriteLine);
                /// then write
                myInbox.OpenForWrite(myLines);
                // Send signal "done write to client"
                myDataOutputStream.writeUTF("Server already got your letter \n");
            }
            /// Check inbox letter
            if (myReadData.substring(0, 10).equals("readLetter")) { // need to have "read/letter/user_name
                List<String> myLinesNew = new LinkedList<String>();
                String[] output = myReadData.split("/");
                String _userRead = (output[1] + "                    ").substring(0, 19);
                /// read all letter of user_name by taking array list from log read File
                myLines = myInbox.OpenForRead();
                for (String myLine : myLines) {
                    InboxData myInboxData_i = new InboxData();
                    myInboxData_i.ExtractLine(myLine);
                    // if user read
                    if (myInboxData_i._to.equals(_userRead)) {
                        // send signal to client
                        myDataOutputStream.writeUTF(myLine);////// try
                        //printInbox(myInboxData_i);
                        // set new status
                        String myLineNew = myLine.substring(0, 240) + "T" + myLine.substring(241, 261);
                        myLinesNew.add(myLineNew);
                    } else { // if not read just write
                        myLinesNew.add(myLine);
                    }
                    // write new status
                    myInbox.OpenForRewrite(myLinesNew);
                }
            }
            // Finish flush
            myDataOutputStream.writeUTF("done");
            myDataOutputStream.flush();////// try
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    // method
    public static String getCurrentDateTime() {
        Date todaysDate = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String todaysDate_str = formatter.format(todaysDate);
        return todaysDate_str;
    }
    public static void printInbox(InboxData myInboxData){
        System.out.println(myInboxData._to+myInboxData._from
                +myInboxData._content+myInboxData._date+myInboxData._date);
    }


}
