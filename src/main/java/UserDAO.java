import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class UserDAO {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/jdbcPrac";
        String id = "root";
//        String id = "jaeyeon";
        String password = "12345";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
