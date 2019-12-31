package data.usecase;

import data.analyzeentity.HeatworkOfUser;
import data.usecase.port.IDataAnalyzeRepository;

import java.util.List;

public class ManagerFindHeatwork {
    private IDataAnalyzeRepository iDataAnalyzeRepository;
    public List<HeatworkOfUser> execut(int pageNum, int pageSize){
        return iDataAnalyzeRepository.findAllHeatwork(pageNum,pageSize);
    }
}
