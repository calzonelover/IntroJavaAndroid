import java.sql.*;

public class MyMain {
    public static void main(String[] args) {
        try {
            // Insert into database
            MyDatabase.ExecuteCommand("INSERT INTO Person (ID, Name,Sex) VALUES(4, 'dude','F')");
            ResultSet myResultSet = MyDatabase.getResultSet("SELECT * FROM Person");
            while(myResultSet.next()){
                System.out.println(myResultSet.getInt(1)+"  "
                    +myResultSet.getString(2)+"  "
                    +myResultSet.getString(3));
            }
        } catch (Exception e){System.out.println(e.getMessage()); }
    }
}
