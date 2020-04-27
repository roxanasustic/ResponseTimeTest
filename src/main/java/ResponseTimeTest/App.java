package ResponseTimeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.UUID;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        String uuid = UUID.randomUUID().toString();
        logger.info("This is a test message" + " | " + uuid);

    }
}

