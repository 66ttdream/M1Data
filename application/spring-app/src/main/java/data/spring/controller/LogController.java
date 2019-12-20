package data.spring.controller;

import data.controller.LogControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@RequestMapping(value="/log")
@RestController
public class LogController {
    private final LogControl logcontrol;
    @Autowired
    public LogController(LogControl logcontrol) {
        this.logcontrol = logcontrol;
    }

    @GetMapping(value = "/set")
    public String setLogConf(HttpServletRequest httpRequest) {
        Map<String, String[]> ans = httpRequest.getParameterMap();
        if(ans.get("eventid")==null){
            return "未关联事件：eventid为空";
        }
        ArrayList al = logcontrol.setConf(ans);
        if(al==null){
            return "参数设置成功";
        }else{
            return "重复参数："+al.toString();
        }
    }
    @GetMapping(value = "gether")
    public void acceptLog(HttpServletRequest httpRequest){
        Map<String, String[]> ans = httpRequest.getParameterMap();
    }
}
