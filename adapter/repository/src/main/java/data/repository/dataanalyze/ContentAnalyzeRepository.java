package data.repository.dataanalyze;

import data.analyzeentity.HeatworkOfUser;
import data.analyzeentity.ShareNum;
import data.analyzeentity.ShareRate;
import data.repository.db.Databases;
import data.repository.model.IHeadwork;
import data.repository.model.IShareNum;
import data.repository.model.IShareRate;
import data.usecase.port.IContentAnalyzeRepository;

import java.util.List;

public class ContentAnalyzeRepository implements IContentAnalyzeRepository {
    /**
     *查询从业者作品内容热度
     * @param userId 从业者的用户唯一标识即内容作者的唯一id
     * @param pageNum 页码
     * @param pageSize 页面条目数（一页的内容有多少条）
     */
    @Override
    public List<HeatworkOfUser> findHeatwork(int userId, int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT contentid COUNT(*) count FROM TESTCONF WHERE pagetype = 1 AND authorid= ? GROUP BY userid ORDER BY count DESC LIMIT "+startPage+","+endPage;
       return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .autoMap(IHeadwork.class)
                .map(IHeadwork::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *查询所有内容页得浏览热度
     * @param pageNum 页码
     * @param pageSize 页面显示条数
     * @return  内容热度分析的领域对象集合
     */
    @Override
    public List<HeatworkOfUser> findAllHeatwork(int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT userid COUNT(*) count FROM TESTCONF WHERE pagetype = 1 AND GROUP BY userid ORDER BY count DESC LIMIT "+startPage+","+endPage;
        return Databases.getDb()
                .select(sql)
                .autoMap(IHeadwork.class)
                .map(IHeadwork::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 查询内容页及其对应被分享次数
     * @param userId 作者id
     * @param pageNum 页码
     * @param pageSize 页面显示数
     * @return 数据库查询结果的传输对象
     */
    @Override
    public List<ShareNum> findContentShareNum(int userId,int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT FROM WHERE LEFT JOIN ORDER BY LIMIT";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareNum.class)
                .map(IShareNum::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 查询内容页及其对应被分享次数
     * @param pageNum 页码
     * @param pageSize  页面显示条数
     * @return  数据库查询结果的传输对象
     */
    @Override
    public List<ShareNum> findAllContentShareNum(int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT FROM WHERE LEFT JOIN GOROUP BY ORDER BY LIMIT";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareNum.class)
                .map(IShareNum::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShareRate> findContentShareRate(int userId){
        var sql = "SELECT FROM WHERE LEFT JOIN GOROUP BY ORDER BY LIMIT";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareRate.class)
                .map(IShareRate::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *
     * @return
     */
    @Override
    public List<ShareRate> findAllContentShareRate(){
        var sql = "SELECT FROM WHERE LEFT JOIN GOROUP BY ORDER BY LIMIT";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareRate.class)
                .map(IShareRate::toDomain)
                .toList()
                .blockingGet();
    }
    public void findTwiceShareRate(int userId){

    }
    public void findAllTwiceShareRate(){

    }
}
