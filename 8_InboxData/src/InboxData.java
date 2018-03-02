import java.util.*;

public class InboxData {
    public String _to;
    public String _from;
    public String _content;
    public String _status;
    public String _date;
    // Constructor
    public InboxData() {
        this._to = "";
        this._from = "";
        this._content = "";
        this._status = "F";
        this._date = "";
    }
    // overlode
    public InboxData(String to, String from, String content,
                     String status, String date){
        this._to = to;
        this._from = from;
        this._content = content;
        this._status = status;
        this._date = date;
    }
    // Method extract line in class
    public InboxData ExtractLine(String line){
        InboxData myInboxData = new InboxData();

        this._to = line.substring(0,20);
        this._from = line.substring(20, 20);
        this._content = line.substring(40, 240);
        this._status = line.substring(240, 1);
        this._date = line.substring(241, 20);

        return myInboxData;
    }
    // Compose line
    public String ComposeLine(InboxData i){
        String myString = "";
        // Tips : "trim" is if it has white space then it will remove
        // (only left and right not to remove white space middle of text)
        myString += (i._to.trim() + WhiteSpace(20)).substring(0, 20) ;
        myString += (i._from.trim() + WhiteSpace(20)).substring(0, 20);
        myString += (i._content.trim() + WhiteSpace(200)).substring(0, 200);
        myString += i._status.trim();
        myString += (i._date.trim() + WhiteSpace(20)).substring(0, 20);

        return myString;
    }

    private String WhiteSpace(int length){
        String s = "";

        for (int i = 0; i < length; i++){
            s += " ";
        }

        return s;
    }

}
