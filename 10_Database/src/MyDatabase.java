/**
 * Created by acer on 23/3/2561.
 */
import java.sql.*;

public class MyDatabase {
    private static Connection getConnection() throws Exception {
        Connection myConnection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String myDatabaseName = "Java";
            String myURL = "jdbc:mysql://localhost:3306/" + myDatabaseName;
            myConnection = DriverManager.getConnection(myURL+"?useSSL=false", "root", "astr0");
        }
        catch (ClassNotFoundException cnfEx) {
            System.out.println("Problem in loading or "
                    + "registering MS SQL Server JDBC driver");
            cnfEx.printStackTrace();
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return myConnection;
    }

    public static ResultSet getResultSet(String sqlCommand) throws Exception {
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = getConnection();
            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery(sqlCommand);
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return myResultSet;
    }

    public static void ExecuteCommand(String sqlCommand) {
        Connection myConnection;
        PreparedStatement myPreparedStatement = null;
        try{
            myConnection = getConnection();
            myPreparedStatement = myConnection.prepareStatement(sqlCommand);
            myPreparedStatement.executeUpdate();

        }catch (Exception e){System.out.println(e.getMessage());}
    }

    public static int ExcuteSQL(String sqlCommand) throws Exception {
        Connection myConnection = null;
        Statement myStatement = null;
        int myUpdateCount = 0;

        try {
            myConnection = getConnection();
            myStatement = myConnection.createStatement();
            myUpdateCount = myStatement.execute(sqlCommand) ? myStatement.getUpdateCount() : 0;
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return myUpdateCount;
    }
}
