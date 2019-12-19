package data.repository.log;

import data.repository.db.Databases;
import data.repository.model.EventConf;
import data.usecase.port.ILogRepository;
import org.davidmoten.rx.jdbc.Database;

import java.util.Map;

public class LogRepository implements ILogRepository {

    @Override
    public void insert(Map<String,String[]> map) {
        Database d = Databases.getDb();
        String[] str = map.get("eventid");
        map.remove("eventid");
        while(map.keySet().iterator().hasNext()){
            var sql = "ALTER TABLE"+map.get("eventid")+" ADD column_name datatype";
        }
    }

    @Override
    public Map findConf() {
        var sql = "SELECT GROUP_CONCAT(COLUMN_NAME SEPARATOR \",\") FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'Data' AND TABLE_NAME = 'tb_name'";
        Databases.getDb()
                .update(sql)
                .complete()
                .blockingAwait();
        return null;
    }
}
