import java.util.*;

public class MyMainServer {

    public static void main(String[] args){
        Inbox myInbox = new Inbox();// Declare before use it to write
        List<String> myLines = new LinkedList<String>();
        InboxData myInboxData = new InboxData();// Declare inbox data

        /// Declare letter
        // First record
        myInboxData._to = "Somsri";
        myInboxData._from = "Somsak";
        myInboxData._content = "How are you";
        myInboxData._status = "F";
        myInboxData._date = "2018-03-02 16:04:00";

        String myWriteLine = myInboxData.ComposeLine(myInboxData);// Compose any data

        myLines.add(myWriteLine);

        // Second record (build letter by )
        InboxData myInboxData2 = new InboxData("Loser", "Winner",
                "Hi dude", "F", "2019-00-00 00:00:00");
        String myWriteLine2 = myInboxData2.ComposeLine(myInboxData2);
        myLines.add(myWriteLine2);

        /// Write file
        myInbox.OpenForWrite(myLines);

        // Then read any hell you wrote
        myLines = myInbox.OpenForRead();
        for (String myLine: myLines){
            System.out.println(myLine);
        }



    }

//    // Ex 1
//    public static void main(String[] args){
//        // declare object
//        Inbox myInbox = new Inbox();
//
//        // mylines array
//        List<String> myLines;//= new LinkedList<String>();
//        /// get myLines from file
//        myLines = myInbox.OpenForRead();
//        // Print any component in myLines
//        for (String myLine: myLines){
//            System.out.println(myLine);
//        }
//        // add component into array myLines
//        myLines.add("!! again !!");
//        myLines.add("you !");
//        myLines.add("dumpass !!!");
//        /// write myLines
//        myInbox.OpenForWrite(myLines); // *** Note that we write in "out.txt" (differ file from read)
//    }
}