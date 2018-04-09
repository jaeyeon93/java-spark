import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOTest {
    private UserDAO userDao;
    private User TestUser;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDAO();
        User TestUser = new User("no2", "12345", "jimmy", "foodsksms@gmail.com");
        userDao.removeUser(TestUser.getId());
    }

    @Test
    public void connect() {
        Connection conn = userDao.getConnection();
        assertNotNull(conn);
    }

    @Test
    public void addUser() throws Exception {
        User user = TestUser;
        userDao.addUser(user);
    }

    @Test
    public void findByUserId() throws SQLException {
//        User user = new User("no1", "12345", "jaeyeon","jaeyeon93@naver.com");
        User user = TestUser;
        userDao.findByUserId(user.getId());
        assertNotNull(user);
    }

    @Test
    public void crud() throws Exception {
        User user = TestUser;
        userDao.removeUser(user.getId());
        userDao.addUser(user);

        User dbUser = userDao.findByUserId(user.getId());
        assertEquals(user, dbUser);
    }

    @Test
    public void findNull() throws Exception {
//        User user = new User("no1", "12345", "jaeyeon","jaeyeon93@naver.com");
        User user = TestUser;
        userDao.removeUser(user.getId());
        User dbUser = userDao.findByUserId(user.getId());
        assertNull(dbUser);
    }
}
