package data.usecase.port;

import java.util.List;

public interface IUserAnalyzeRepository {
    public int findUser(int userId);
    public int findAllUser();
    public int findNewAddUser(int userId,String beginTime, String endTime);
    public int findAllNewAddUser(String beginTime, String endTime);
    public int findAllActiveUserNum(String beginTime, String endTime);
    public int findActiveUserNum(int userId ,String beginTime, String endTime);
    public List<Integer> findUseTimeFrame(int userId,String beginTime,String endTime,int frame);
    public List<Integer> findAllUseTimeFrame(String beginTime,String endTime,int frame);
}
