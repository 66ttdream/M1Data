package data.spring.conf;

import data.repository.dataanalyze.ContentAnalyzeRepository;
import data.repository.dataanalyze.UserAnalyzeRepository;
import data.usecase.*;
import data.usecase.port.IContentAnalyzeRepository;
import data.usecase.port.IUserAnalyzeRepository;

public class DataAnalyzeSpringConf {
    private final IUserAnalyzeRepository iUserAnalyzeRepository = new UserAnalyzeRepository();
    private final IContentAnalyzeRepository iContentAnalyzeRepository = new ContentAnalyzeRepository();
    public ManagerFindActiveUser getManagerFindActiveUser(){
        return new ManagerFindActiveUser(iUserAnalyzeRepository);
    }
    public ManagerFindHeatwork getManagerFindHeatwork(){
        return new ManagerFindHeatwork(iContentAnalyzeRepository);
    }
    public ManagerFindShareNum getManagerFindShareNum(){
        return new ManagerFindShareNum(iContentAnalyzeRepository);
    }
    public ManagerFindShareRate getManagerFindShareRate(){
        return new ManagerFindShareRate(iContentAnalyzeRepository);
    }
    public ManagerFindUser getManagerFindUser(){
        return new ManagerFindUser(iUserAnalyzeRepository);
    }
    public ManagerFindUseTimeFrame getManagerFindUseTimeFrame(){
        return new ManagerFindUseTimeFrame(iUserAnalyzeRepository);
    }
    public ManagerFinNewAddUser getManagerFinNewAddUser(){
        return new ManagerFinNewAddUser(iUserAnalyzeRepository);
    }
    public PractitionerFindActiveUser getPractitionerFindActiveUser(){
        return new PractitionerFindActiveUser(iUserAnalyzeRepository);
    }
    public PractitionerFindHeatwork getPractitionerFindHeatwork(){
        return new PractitionerFindHeatwork(iContentAnalyzeRepository);
    }
    public PractitionerFindNewAddUser getPractitionerFindNewAddUser(){
        return new PractitionerFindNewAddUser(iUserAnalyzeRepository);
    }
    public PractitionerFindShareNum getPractitionerFindShareNum(){
        return new PractitionerFindShareNum(iContentAnalyzeRepository);
    }
    public PractitionerFindShareRate getPractitionerFindShareRate(){
        return new PractitionerFindShareRate(iContentAnalyzeRepository);
    }
    public PractitionerFindUser getPractitionerFindUser(){
        return new PractitionerFindUser(iUserAnalyzeRepository);
    }
    public PractitionerFindUseTimeFrame getPractitionerFindUseTimeFrame(){
        return new PractitionerFindUseTimeFrame(iUserAnalyzeRepository);
    }
}
