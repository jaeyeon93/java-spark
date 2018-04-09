import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.*;

public class UserDAOTest {
    @Test
    public void connect() {
        UserDAO userDao = new UserDAO();
        Connection conn = userDao.getConnection();
        assertNotNull(conn);
    }
}
