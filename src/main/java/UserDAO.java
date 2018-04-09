import java.sql.*;

public class UserDAO {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/jdbcPrac";
        String id = "root";
        String password = "12345";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addUser(User user) throws SQLException {
        String sql = "insert into users values(?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());
        pstmt.executeUpdate();
    }

    public User findByUserId(String userId) throws SQLException {
        String sql = "select * from users where userId = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, userId);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            User user = new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email"));
            return user;
        }
        return null;
    }

    public void removeUser(String userId) throws SQLException {
        String sql = "delete from users where userId = ?";
        PreparedStatement pstmp = getConnection().prepareStatement(sql);
        pstmp.executeUpdate();
    }
}
