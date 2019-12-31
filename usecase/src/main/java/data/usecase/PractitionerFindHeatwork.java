package data.usecase;
import data.analyzeentity.HeatworkOfUser;
import data.usecase.port.IDataAnalyzeRepository;

import java.util.List;

public class PractitionerFindHeatwork {
    private IDataAnalyzeRepository iDataAnalyzeRepository;
    public List<HeatworkOfUser> execut(int userId, int pageNum, int pageSize){
        List<HeatworkOfUser> list = iDataAnalyzeRepository.findHeatwork(userId,pageNum,pageSize);
        return list;
    }
}
