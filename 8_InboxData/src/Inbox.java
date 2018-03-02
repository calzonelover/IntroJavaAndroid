import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;
/*
Want Letter
To : 20 byte
From : 20 byte
Content: 200
status : 1 (T/F)
DateTime : 20
====== Then Divide into ... for get the input ======
[0->19][20->39][40->239][240][241->260]
*/

public class Inbox {
    public String _to;
    public String _from;
    public String _content;
    public String _status;
    public String _date;

    private final String _FILE_NAME = "/Users/jab/Desktop/Java/8_InboxData/Inbox.txt";
    private final String _FILE_NAME_2 = "/Users/jab/Desktop/Java/8_InboxData/Inbox.txt";

    public Inbox(){
        // Do nothing
    }

    public List<String> OpenForRead(){
        List<String> myLines = new LinkedList<String>();

        try{
            Path myFile = Paths.get(_FILE_NAME);
            BufferedReader myReader = Files.newBufferedReader(myFile, StandardCharsets.UTF_8);
            String myLine = null;

            while((myLine = myReader.readLine()) != null){
                myLines.add(myLine);
            }
            myReader.close();

        } catch (IOException e){
            // do something
            System.err.println("IO Exception: "+e.getMessage());
        }
        return myLines;
    }
    public void OpenForWrite(List<String> myLines){
        try{
            Path myFile = Paths.get(_FILE_NAME_2);
            BufferedWriter myWriter = Files.newBufferedWriter(myFile, StandardCharsets.UTF_8);

            for (String myLine: myLines){
                myWriter.write(myLine);
                myWriter.newLine();
            }
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("IO Exception : "+e);
        }
    }
}