
import java.sql.*;

public class conn {

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/signup", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error" + ex.getMessage());
            return null;
        }
    }

    private static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Database.close() Error " + ex.getMessage());
        }
    }

    public static boolean Login(String Email, String Password) {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM login_tbl WHERE Email='" + Email + "' AND password='" + Password + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error " + ex.getMessage());
            return false;
        } finally {
            close(con);
        }
        return false;
    }

    public static boolean Sign_Up(String Email, String Password, String Cell_No, String Address) {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            String query = "INSERT INTO login_tbl VALUES( '" + Email + "', '" + Password + "', '" + Cell_No + "', '" + Address + "')";
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println("signup error " + ex.getMessage());
            return false;
        } finally {
            close(con);
        }
        return false;

    }
}
