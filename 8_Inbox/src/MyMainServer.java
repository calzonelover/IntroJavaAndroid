import java.util.*;

public class MyMainServer {

    // Ex 1
    public static void main(String[] args){
        // declare object
        Inbox myInbox = new Inbox();

        // mylines array
        List<String> myLines;//= new LinkedList<String>();
        /// get myLines from file
        myLines = myInbox.OpenForRead();
        // Print any component in myLines
        for (String myLine: myLines){
            System.out.println(myLine);
        }
        // add component into array myLines
        myLines.add("!! again !!");
        myLines.add("you !");
        myLines.add("dumpass !!!");
        /// write myLines
        myInbox.OpenForWrite(myLines); // *** Note that we write in "out.txt" (differ file from read)
    }
}