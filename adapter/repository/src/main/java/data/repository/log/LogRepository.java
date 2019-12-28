package data.repository.log;

import data.repository.db.Databases;
import data.usecase.port.ILogRepository;
import org.davidmoten.rx.jdbc.Database;

import java.util.*;

public class LogRepository implements ILogRepository {

    @Override
    public void insert(Map<String,String[]> map) {
        Database db = Databases.getDb();
        String str = map.get("eventid")[0];
        //map.remove("eventid",map.get("eventid"));
        StringBuffer sb = new StringBuffer();
        Iterator it = map.keySet().iterator();
        String sql;
        Map<String,String> m = new HashMap<String,String>();

        while (it.hasNext()){
            String key =  (String)it.next();
            m.put(key,map.get(key)[0]);
        }
        m.remove("eventid",m.get("eventid"));
        Iterator itr = m.keySet().iterator();
        switch (str){
            case "1":
                System.out.println(map.get("eventid")[0]);
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE TESTCONF ADD "+"( "+sb.toString()+" )";
                System.out.println(sql);
                db
                .update(sql)
                .complete()
                .blockingAwait();
                break;
            case "2":
                //map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");

                }
                sql = "ALTER TABLE SHAREPAGE ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "3":
                map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");
                    //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";

                }
                sql = "ALTER TABLE COSMETOLOGIST ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "4":
                map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");
                    //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";

                }
                sql = "ALTER TABLE OPENAPP ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "5":
                map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");
                    //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";

                }
                sql = "ALTER TABLE FORWARDINGAPP ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "6":
                map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");
                    //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";

                }
                sql = "ALTER TABLE ASTERISKAPP ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "7":
                map.remove("eventid");
                while(it.hasNext()){
                    var key  = it.next();
                    sb.append(key);
                    sb.append(" "+map.get(key)[0]);
                    sb.append(",");
                    //var sql = "ALTER TABLE TESTCONF ADD column_name datatype";

                }
                sql = "ALTER TABLE APPOINTMENT ADD "+"( "+sb.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
        }
    }

    @Override
    public List<String> findConf(String eventid) {
        Database db = Databases.getDb();
        List<String> list = null;
        String sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME = ?";
                //= "SELECT COLUMN_NAME FROM information_schema.COLUMNS\n" + "WHERE TABLE_NAME = 'TESTCONF'";
        switch (eventid){
            case "1":
                list=db.select(sql)
                    .parameter("TESTCONF")
                    .getAs(String.class)
                    .toList()
                    .blockingGet();
                break;
            case "2":
                list=db.select(sql)
                        .parameter("SHAREPAGE")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "3":
                list=db.select(sql)
                        .parameter("COSMETOLOGIST")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "4":
                list=db.select(sql)
                    .parameter("OPENAPP")
                    .getAs(String.class)
                    .toList()
                    .blockingGet();
                break;
            case "5":
                list=db.select(sql)
                    .parameter("FORWARDINGAPP")
                    .getAs(String.class)
                    .toList()
                    .blockingGet();
                break;
            case "6":
                list=db.select(sql)
                        .parameter("ASTERISKAPP")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "7":
                list=db.select(sql)
                    .parameter("APPOINTMENT")
                    .getAs(String.class)
                    .toList()
                    .blockingGet();
                break;
        }
        //ArrayList<String> al = new ArrayList<String>(list);
        return list;
    }

    @Override
    public void upData(Map<String,String> map) {
         Database db = Databases.getDb();
         Iterator it = map.keySet().iterator();
         StringBuffer sb = new StringBuffer();
         while (it.hasNext()){
             sb.append(map.get(it.next())+",");
         }
         sb.deleteCharAt(sb.length()-1);
         String sql;
         //= "INSERT INTO "+"tablename"+" VALUES( "+"values";
         String eventid = map.get("eventid");
         switch (eventid){
             case "1":
                 sql = "INSERT INTO "+"TESTCONF"+" VALUES( "+sb.toString()+" )";
                 System.out.println(sql);
                         db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
             case "2":
                 sql = "INSERT INTO "+"SHAREPAGE"+" VALUES( "+sb.toString()+" )";
                         db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
             case "3":
                 sql = "INSERT INTO "+"COSMETOLOGIST"+" VALUES( "+sb.toString()+" )";
                 db
                  .update(sql)
                  .complete()
                  .blockingAwait();
                 break;
             case "4":
                 sql = "INSERT INTO "+"OPENAPP"+" VALUES( "+sb.toString()+" )";
                        db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
             case "5":
                 sql = "INSERT INTO "+"FORWARDINGAPP"+" VALUES( "+sb.toString()+" )";
                         db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
             case "6":
                 sql = "INSERT INTO "+"ASTERISKAPP"+" VALUES( "+sb.toString()+" )";
                        db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
             case "7":
                 sql = "INSERT INTO "+"APPOINTMENT"+" VALUES( "+sb.toString()+" )";
                        db
                         .update(sql)
                         .complete()
                         .blockingAwait();
                 break;
         }
    }
}
