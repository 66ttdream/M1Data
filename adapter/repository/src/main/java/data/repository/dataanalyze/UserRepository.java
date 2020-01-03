package data.repository.dataanalyze;

import data.repository.db.Databases;

public class UserRepository {
    public static String findUserById(int userId){
        var sql = "SELECT contentName FROM CONTENT WHERE contentId=?";
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(String.class)
                .blockingFirst();
    }
}
