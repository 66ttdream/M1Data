package data.repository.db;

import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.DatabaseType;

import java.util.concurrent.TimeUnit;

public class Databases {
    static String  url = "jdbc:mysql://192.168.1.250:3306/data";
    static int maxPoolSize = 20;

    public static Database getDb() {
        //Database db = Database.from(url, maxPoolSize);
        Database db = Database
                .nonBlocking()  // 连接池类型（非阻塞）
                .url(url)  // 连接地址
                .maxIdleTime(30, TimeUnit.MINUTES)  //连接空闲时生存时间
                .healthCheck(DatabaseType.MYSQL)// 设置数据库类型
                .idleTimeBeforeHealthCheck(5, TimeUnit.SECONDS)
                .maxPoolSize(20)//连接池最大连接数
                .build();
        return db;
    }
}
