/**
 * Created by acer on 24/2/2561.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyMain {

    public static void main(String[] args) throws Exception {

        // variables
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        // Step 1: Loading or registering MS SQL JDBC driver class
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS SQL Server JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

//            String myDatabaseName = "databaseName=BCI;integratedSecurity=true;";
            String myDatabaseName = "databaseName=BCI";
            String myURL = "jdbc:mysql://localhost:3306ว" + myDatabaseName;

            // Step 2.A: Create and get connection using DriverManager class
            myConnection = DriverManager.getConnection(myURL, "root", "root");

            // Step 2.B: Creating JDBC Statement
            myStatement = myConnection.createStatement();

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            myResultSet = myStatement.executeQuery("SELECT * FROM M_COMPANIES");

            System.out.println("Company ID\t\t\tCompany Code");
            System.out.println("==========\t\t\t======================");

            // processing returned data and printing into console
            while(myResultSet.next()) {
                System.out.println(myResultSet.getInt(1) + "\t\t\t\t\t" +
                        myResultSet.getString(2));
            }
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {

            // Step 3: Closing database connection
            try {
                if (null != myConnection) {

                    // cleanup resources, once after processing
                    myResultSet.close();
                    myStatement.close();

                    // and then finally close connection
                    myConnection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
}