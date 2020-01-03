package data.repository.dataanalyze;

import data.repository.db.Databases;
import data.usecase.port.IUserAnalyzeRepository;
import org.davidmoten.rx.jdbc.Database;
import util.Time;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class UserAnalyzeRepository implements IUserAnalyzeRepository {
    /**
     * 从业者查询其用户数
     * @return 全部用户数
     */
    public int findUser(int userId){
        var sql = "SELECT COUNT(DISTINCT(userid)) FROM TESTCONF";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;

    }

    /**
     * 查询用户总数
     * @return
     */
    public int findAllUser(){
        var sql = "SELECT COUNT(DISTINCT(userid)) FROM TESTCONF";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;

    }

    /**
     *查询时段内从业者新增的用户量
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findNewAddUser(int userId,String beginTime, String endTime){
        var sql = "SELECT a.userid FROM (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(logintime,'%Y%m%d')=DATE_FORMAT(NOW(),'%Y%m%d') a) union SELECT userid FROM b (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(logintime,'%Y%m%d')<DATE_FORMAT(NOW(),'%Y%m%d') b)";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     *查询时间段内新增的用户数量
     * @param beginTime  需要查询时段的开始时间
     * @param endTime 需要查询时段的结束时间
     * @return
     */
    public int findAllNewAddUser(String beginTime, String endTime){
        var sql = "SELECT a.userid FROM (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(logintime,'%Y%m%d')=DATE_FORMAT(NOW(),'%Y%m%d') a) union SELECT userid FROM b (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(logintime,'%Y%m%d')<DATE_FORMAT(NOW(),'%Y%m%d') b)";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询时间段内活跃的用户总数
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findAllActiveUserNum(String beginTime, String endTime){
        var sql = "SELECT COUNT(DISTINCT(userId)) FROM D_LOADRESOURCE WHERE time BETWEEN "+beginTime+" "+endTime;
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询从业者的用户活跃数
     * @param userId 从业者Id
     * @param beginTime 需查询时间段的开始时间
     * @param endTime 需查询时间段的结束时间
     * @return
     */
    public int findActiveUserNum(int userId ,String beginTime, String endTime){
        var sql = "SELECT COUNT(DISTINCT(userId)) FROM D_LOADRESOURCE WHERE time BETWEEN "+beginTime+" "+endTime+ "AND userId=?";
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     *查询用户使用时间段
     * @param userId 从业者id
     * @param beginTime
     * @param endTime
     * @param frame 划分一天24小时为多少段
     * @return
     */
    public List<Integer> findUseTimeFrame(int userId,String beginTime,String endTime,int frame){
        Database db = Databases.getDb();
        Map<String,String> map = Time.getTimeFrame(frame);
        Iterator it = map.keySet().iterator();
        List<Integer> list = new LinkedList<Integer>();
        String sql;
        if(beginTime==null&&endTime==null){
            sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOGINAPP";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()){
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(d.logintime) FROM (SELECT logintime FROM TESTCONF WHERE DATE_FORMAT(logintime,'%H:%i:%s')>"+"'"+key+"'"+" AND DATE_FORMAT(logintime,'%H:%i:%s')<"+"'"+map.get(key)+"'"+") d";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }else {
            sql = "SELECT COUNT(d.logintime) FROM (SELECT logintime FROM TESTCONF WHERE logintime<"+"'"+beginTime+"'"+"definedendtime AND logintime>"+"'"+endTime+"'"+") d";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(y.logintime) FROM (SELECT logintime  from  countofdefined x  where x.logintime BETWEEN begintime AND endtime) y";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }
    }

    /**
     * 查询用户使用时间段
     * @param beginTime
     * @param endTime
     * @param frame
     * @return 划分一天24小时为多少段
     */
    public List<Integer> findAllUseTimeFrame(String beginTime, String endTime, int frame){
        Database db = Databases.getDb();
        Map<String,String> map = Time.getTimeFrame(frame);
        Iterator it = map.keySet().iterator();
        List<Integer> list = new LinkedList<Integer>();
        String sql;
        if(beginTime==null&&endTime==null){
            sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOGINAPP";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()){
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(d.logintime) FROM (SELECT logintime FROM TESTCONF WHERE DATE_FORMAT(logintime,'%H:%i:%s')>"+"'"+key+"'"+" AND DATE_FORMAT(logintime,'%H:%i:%s')<"+"'"+map.get(key)+"'"+") d";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                ;
                list.add(data);
            }
            return list;
        }else {
            sql = "SELECT COUNT(d.logintime) FROM (SELECT logintime FROM TESTCONF WHERE logintime<"+"'"+beginTime+"'"+"definedendtime AND logintime>"+"'"+endTime+"'"+") d";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(y.logintime) FROM (SELECT logintime  from  countofdefined x  where x.logintime BETWEEN begintime AND endtime) y";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }
    }
}
