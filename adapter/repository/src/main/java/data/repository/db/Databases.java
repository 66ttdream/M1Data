package data.repository.db;

import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.DatabaseType;

import java.util.concurrent.TimeUnit;

public class Databases {
    private static String  url = "jdbc:mysql://192.168.1.250:3306/data";
    private static int maxPoolSize = 20;

    public static Database getDb() {
        //Database db = Database.from(url, maxPoolSize);
        Database db = Database
                .nonBlocking()
                // the jdbc url of the connections to be placed in the pool
                .url(url)
                // an unused connection will be closed after thirty minutes
                .maxIdleTime(30, TimeUnit.MINUTES)
                .user("root")
                .password("*u!-w;j*#2&J")
                // connections are checked for healthiness on checkout if the connection
                // has been idle for at least 5 seconds
                .healthCheck(DatabaseType.MYSQL)
                .idleTimeBeforeHealthCheck(5, TimeUnit.SECONDS)
                // if a connection fails creation then retry after 30 seconds
                // the maximum number of connections in the pool
                .maxPoolSize(maxPoolSize)
                .build();
        return db;
    }
}
