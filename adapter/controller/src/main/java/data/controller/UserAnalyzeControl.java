package data.controller;

import data.usecase.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserAnalyzeControl {
    private ManagerFindUser managerFindUser;
    private PractitionerFindUser practitionerFindUser;
    private ManagerFinNewAddUser managerFinNewAddUser;
    private PractitionerFindNewAddUser practitionerFindNewAddUser;
    private ManagerFindActiveUser managerFindActiveUser;
    private PractitionerFindActiveUser practitionerFindActiveUser;
    private ManagerFindUseTimeFrame managerFindUseTimeFrame;
    private PractitionerFindUseTimeFrame practitionerFindUseTimeFrame;
    public int getAllUserNum(){
        return managerFindUser.execut();
    }
    public int getUserNum(int userId){
        return practitionerFindUser.execut(userId);
    }
    public int getNewAddUser(int userId,String beginTime, String endTime){
        return practitionerFindNewAddUser.execut(userId,beginTime,endTime);
    }
    public int getAllNewAddUser(String beginTime, String endTime){
        return managerFinNewAddUser.execut(beginTime,endTime);
    }
    public int getActiveUser(int userId ,String beginTime, String endTime){
        return practitionerFindActiveUser.execut(userId,beginTime,endTime);
    }
    public int getAllActiveUser(String beginTime, String endTime){
        return managerFindActiveUser.execut(beginTime,endTime);
    }
    public List getUseTimeFrame(int userId,String beginTime,String endTime,int frame){
        return practitionerFindUseTimeFrame.execut(userId, beginTime, endTime, frame);
    }
    public List getAllUseTimeFrame(String beginTime,String endTime,int frame){
        return managerFindUseTimeFrame.execut(beginTime, endTime, frame);
    }

}
