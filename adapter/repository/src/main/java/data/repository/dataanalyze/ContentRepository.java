package data.repository.dataanalyze;

import data.repository.db.Databases;


public class ContentRepository {
    /**
     * 通过内容id查询内容表获取作品名称
     * @pram contentId 用户作品id
     * @return
     */
    public static String findContentById(int contentId){
        var sql = "SELECT contentName FROM CONTENT WHERE contentId=?";
        return Databases.getDb()
                .select(sql)
                .parameter(contentId)
                .getAs(String.class)
                .blockingFirst();
    }
}
