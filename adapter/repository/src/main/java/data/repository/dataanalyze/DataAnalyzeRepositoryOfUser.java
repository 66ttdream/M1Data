package data.repository.dataanalyze;

import data.analyzeentity.HeatworkOfUser;
import data.repository.db.Databases;
import data.repository.model.IHeadwork;
import data.usecase.port.IDataAnalyzeRepository;

import java.util.List;

public class DataAnalyzeRepositoryOfUser implements IDataAnalyzeRepository {
    /**
     *
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
}
