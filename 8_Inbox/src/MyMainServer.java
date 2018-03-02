import java.util.*;

public class MyMainServer {
    public static void main(String[] args){
        // declare onject
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
        myInbox.OpenForWrite(myLines);
    }
}