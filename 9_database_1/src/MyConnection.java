/**
 * Created by acer on 24/2/2561.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MyConnection {
    public static Connection getConnection() throws Exception {
        //Driver d = (Driver) Class.forName
        //        ("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        Connection c = DriverManager.getConnection(
                "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=*.accdb"
        );
        return c;
    }
}