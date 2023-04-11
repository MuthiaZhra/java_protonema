package MuthiaZahra.pencatatan.buku.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtilTest {
    @Test
    void testConnection() throws SQLException{
    
        //Data Source
        HikariDataSource dataSource = DatabaseUtil.getDataSource();

        //connection
        Connection connection = dataSource.getConnection();
        connection.close();
        dataSource.close();
        

    }
}
