import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
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

    private final String _FILE_NAME = "/Users/jab/Desktop/Java/8_HW_ServerInbox/letter.txt";

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
    public void OpenForWrite(List<String> myLines_in){
        List<String> myLines = new LinkedList<String>();
        Path myFile = Paths.get(_FILE_NAME);
        try{
            // reopen file and add email list
            BufferedReader myReader = Files.newBufferedReader(myFile, StandardCharsets.UTF_8);
            String myLine = null;
            while((myLine = myReader.readLine()) != null){
                myLines.add(myLine);
            }
            myReader.close();
            // add new letter to old list of letter
            for (String myLineAdd: myLines_in){
                myLines.add(myLineAdd);
            }
            // open file for write
            BufferedWriter myWriter = Files.newBufferedWriter(myFile, StandardCharsets.UTF_8);
            // write
            for (String myLineAdd: myLines){
                myWriter.write(myLineAdd);
                myWriter.newLine();
            }
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("IO Exception : "+e);
        }
    }
    public void OpenForRewrite(List<String> myLines_in){
        List<String> myLines = new LinkedList<String>();
        Path myFile = Paths.get(_FILE_NAME);
        try{
            BufferedWriter myWriter = Files.newBufferedWriter(myFile, StandardCharsets.UTF_8);
            // write
            for (String myLineAdd: myLines_in){
                myWriter.write(myLineAdd);
                myWriter.newLine();
            }
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("IO Exception : "+e);
        }
    }
}