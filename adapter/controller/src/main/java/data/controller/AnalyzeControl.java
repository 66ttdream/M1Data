package data.controller;

import data.analyzeentity.HeatworkOfUser;
import data.controller.modle.Heatwork;
import data.usecase.ManagerFindHeatwork;
import data.usecase.PractitionerFindHeatwork;

import java.util.LinkedList;
import java.util.List;

public class AnalyzeControl {
    private PractitionerFindHeatwork practitionerFindHeatwork;
    private ManagerFindHeatwork managerFindHeatwork;
    public List<Heatwork> getHeatwork(int userId, int pageNum, int pageSize){
        List<HeatworkOfUser> list = practitionerFindHeatwork.execut(userId,pageNum,pageSize);
        List<Heatwork> l = new LinkedList<Heatwork>();
        for(HeatworkOfUser heatworkOfUser: list ){
            Heatwork heatwork =  Heatwork.builder()
                    .contentName(heatworkOfUser.getContentName())
                    .pageView(heatworkOfUser.getPageView())
                    .build();
            l.add(heatwork);
        }
        return l;
    }
    public List<Heatwork> getAllHeatwork(int pageNum, int pageSize) {
        List<Heatwork> l = new LinkedList<Heatwork>();
        List<HeatworkOfUser> list = managerFindHeatwork.execut(pageNum, pageSize);
        for (HeatworkOfUser heatworkOfUser : list) {
            Heatwork heatwork = Heatwork.builder()
                    .contentName(heatworkOfUser.getContentName())
                    .pageView(heatworkOfUser.getPageView())
                    .build();
            l.add(heatwork);
        }
        return l;
    }
}
