package data.spring.controller;

import data.controller.UserAnalyzeControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "analyse")
@RestController
public class UserAnalyzeController {
    private UserAnalyzeControl userAnalyzeControl;
    @Autowired
    public UserAnalyzeController(UserAnalyzeControl userAnalyzeControl){
        this.userAnalyzeControl = userAnalyzeControl;
    }

    @GetMapping(value = "usernum/manager")
    public int getAllUserNum(){
        return userAnalyzeControl.getAllUserNum();
    }
    @GetMapping(value = "usernum/practitioner")
    public int getUserNum(@PathVariable int userId){
        return userAnalyzeControl.getUserNum(userId);
    }
    @GetMapping(value = "newadduser/practitioner")
    public int getNewAddUser(@PathVariable int userId,String beginTime, String endTime){
        return userAnalyzeControl.getNewAddUser(userId,beginTime,endTime);
    }
    @GetMapping(value = "newadduser/manager")
    public int getAllNewAddUser(@PathVariable String beginTime, String endTime){
        return userAnalyzeControl.getAllNewAddUser(beginTime,endTime);
    }
    @GetMapping(value = "activeuser/practitioner")
    public int getActiveUser(@PathVariable int userId,String beginTime, String endTime){
        return userAnalyzeControl.getActiveUser(userId,beginTime,endTime);
    }
    @GetMapping(value = "activeuser/manager")
    public int getAllActiveUser(@PathVariable String beginTime, String endTime){
        return userAnalyzeControl.getAllActiveUser(beginTime,endTime);
    }
    @GetMapping(value = "usetimeframe/practitioner")
    public List getAllUseTimeFrame(@PathVariable int userId, String beginTime, String endTime, int frame){
        return userAnalyzeControl.getUseTimeFrame(userId, beginTime, endTime, frame);
    }
    @GetMapping(value = "usetimeframe/manager")
    public List getUseTimeFrame(@PathVariable String beginTime, String endTime,int frame){
        return userAnalyzeControl.getAllUseTimeFrame(beginTime, endTime, frame);
    }

}
