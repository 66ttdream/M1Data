package data.repository.log;

import data.repository.db.Databases;
import data.usecase.port.ILogRepository;
import org.davidmoten.rx.jdbc.Database;

import java.util.*;

public class LogRepository implements ILogRepository {

    @Override
    public void insert(Map<String,String[]> map) {
        Database d = Databases.getDb();
        String[] str = map.get("eventid");
        map.remove("eventid");
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            //System.out.println(it.next().toString());
            //System.out.println((map.get(it.next()))[0].toString());
            var key  = it.next();
            var sql = "ALTER TABLE TESTCONF ADD "+key.toString()+" "+map.get(key)[0].toString();
            System.out.println(sql);
            //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";
            Databases.getDb()
                    .update(sql)
                    .complete()
                    .blockingAwait();
        }
    }

    @Override
    public List<String> findConf(String eventid) {
        var sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS\n" +
                "WHERE TABLE_NAME = 'TESTCONF'";
        List<String> list = Databases.getDb()
                .select(sql)
                .getAs(String.class)
                .toList()
                .blockingGet();
        /*for(String string:list){
            map.put(string,null);
        }*/
        return list;
    }

    @Override
    public void upData(Map<String,String[]> map) {
         String sql = "ALTER TABLE table_name\n" +
                      "ADD column_name datatype";
         String eventid = map.get("evevtid")[0];
         switch (eventid){
             case "1":
             case "2":
             case "3":
             case "4":
             case "5":
             case "6":
             case "7":
         }
    }
}
