package data.spring.config;

import data.controller.ContentAnalyzeControl;
import data.controller.UserAnalyzeControl;
import data.spring.conf.DataAnalyzeSpringConf;
import data.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAnalyzeConf {
    private final DataAnalyzeSpringConf dataAnalyzeSpringConf  = new DataAnalyzeSpringConf();
    @Bean
    public ManagerFindActiveUser  getManagerFindActiveUser (){
        return dataAnalyzeSpringConf.getManagerFindActiveUser();
    }
    @Bean
    public ManagerFindHeatwork getManagerFindHeatwork(){
        return dataAnalyzeSpringConf.getManagerFindHeatwork();
    }
    @Bean
    public ManagerFindShareNum getManagerFindShareNum(){
        return dataAnalyzeSpringConf.getManagerFindShareNum();
    }
    @Bean
    public ManagerFindShareRate getManagerFindShareRate(){
        return dataAnalyzeSpringConf.getManagerFindShareRate();
    }
    @Bean
    public ManagerFindUser getManagerFindUser(){
        return dataAnalyzeSpringConf.getManagerFindUser();
    }
    @Bean
    public ManagerFindUseTimeFrame getManagerFindUseTimeFrame() {
        return dataAnalyzeSpringConf.getManagerFindUseTimeFrame() ;
    }
    @Bean
    public ManagerFinNewAddUser  getManagerFinNewAddUser() {
        return dataAnalyzeSpringConf.getManagerFinNewAddUser();
    }
    @Bean
    public PractitionerFindActiveUser getPractitionerFindActiveUser() {
        return dataAnalyzeSpringConf.getPractitionerFindActiveUser();
    }
    @Bean
    public PractitionerFindHeatwork getPractitionerFindHeatwork() {
        return dataAnalyzeSpringConf.getPractitionerFindHeatwork();
    }
    @Bean
    public PractitionerFindNewAddUser getPractitionerFindNewAddUser() {
        return dataAnalyzeSpringConf.getPractitionerFindNewAddUser();
    }
    @Bean
    public PractitionerFindShareNum getPractitionerFindShareNum() {
        return dataAnalyzeSpringConf.getPractitionerFindShareNum();
    }
    @Bean
    public PractitionerFindShareRate getPractitionerFindShareRate() {
        return dataAnalyzeSpringConf.getPractitionerFindShareRate();
    }
    @Bean
    public PractitionerFindUser getPractitionerFindUser() {
        return dataAnalyzeSpringConf.getPractitionerFindUser();
    }
    @Bean
    public PractitionerFindUseTimeFrame getPractitionerFindUseTimeFrame() {
        return dataAnalyzeSpringConf.getPractitionerFindUseTimeFrame();
    }
    @Bean
    public ContentAnalyzeControl getContentAnalyzeControl(){
        return new ContentAnalyzeControl(getPractitionerFindHeatwork(),getManagerFindHeatwork(),getManagerFindShareNum(),getPractitionerFindShareNum(),getManagerFindShareRate(),getPractitionerFindShareRate());
    }
    @Bean
    public UserAnalyzeControl  getUserAnalyzeControl(){
        return new UserAnalyzeControl(getManagerFindUser(),getPractitionerFindUser(),getManagerFinNewAddUser(),getPractitionerFindNewAddUser(),getManagerFindActiveUser(),getPractitionerFindActiveUser(),getManagerFindUseTimeFrame(),getPractitionerFindUseTimeFrame());
    }

}
