import java.sql.*;

class MyTest{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Access via docker
            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.0.1:3306/myJavaDB"
                    , "root", "mypassword");
            // Connection con=DriverManager.getConnection(
            //         "jdbc:mysql://localhost:3306/Java","root","password");
            //here sonoo is database name, root is username and password
            System.out.println("\n !! Pass !!  \n");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Employee");
//            ResultSet rs=stmt.executeQuery("select * from Person");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}