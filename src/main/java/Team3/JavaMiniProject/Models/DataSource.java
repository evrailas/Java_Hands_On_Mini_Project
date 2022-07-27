package Team3.JavaMiniProject.Models;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    private static final Lorem generator = LoremIpsum.getInstance();

    private static final String DB_CONNECTION_URL_FILE_MODE = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "123456789";


    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(DB_CONNECTION_URL_FILE_MODE );
        config.setUsername( DB_USERNAME );
        config.setPassword( DB_PASSWORD );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private DataSource() {}
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
