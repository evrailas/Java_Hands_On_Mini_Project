package Team3.JavaMiniProject;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class DatabaseConnection {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private static final Lorem generator = LoremIpsum.getInstance();

    private static final String DB_CONNECTION_URL_FILE_MODE = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "123456789";



    private void initializeHikari(HikariDataSource hikariDataSource) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_CONNECTION_URL_FILE_MODE);
        config.setUsername(DB_USERNAME);
        config.setPassword(DB_PASSWORD);
        config.setConnectionTimeout(10000);
        config.setIdleTimeout(60000);
        config.setMaxLifetime(1800000);
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(5);
        config.setAutoCommit(true);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        hikariDataSource = new HikariDataSource(config);
    }

    private void loadDatabaseDriver() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("Oracle JDBC driver server has been successfully loaded.");
    }
}
