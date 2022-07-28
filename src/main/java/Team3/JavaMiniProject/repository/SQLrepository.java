package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.ACMEappMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.exit;


public class SQLrepository {

    private static final Logger logger = LogManager.getLogger(ACMEappMain.class);
    private static final Properties sqlCommands = new Properties();

    // we only want the following to happen once at the beginning
    static {
        try (InputStream inputStream = SQLrepository.class.getClassLoader().getResourceAsStream(
                "sql.properties")) {
            if (inputStream == null) {
                logger.error("Unable to find sql.properties, exiting application.");
                exit(-1);
            }
            sqlCommands.load(inputStream);
        } catch (IOException ex) {
            logger.error("Unable to read sql.properties, exiting application.", ex);
            exit(-1);
        }
    }

    private SQLrepository() {
    }

    public static String get(String commandKey) {
        return sqlCommands.getProperty(commandKey);
    }
}
