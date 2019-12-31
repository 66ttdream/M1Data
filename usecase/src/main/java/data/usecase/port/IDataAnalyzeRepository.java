package data.usecase.port;

import data.analyzeentity.HeatworkOfUser;

import java.util.List;

public interface IDataAnalyzeRepository {
    public List<HeatworkOfUser> findHeatwork(int userId, int pageNum, int pageSize);
    public List<HeatworkOfUser> findAllHeatwork(int pageNum, int pageSize);
}
