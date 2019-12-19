package data.spring.controller;

import data.controller.LogControl;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@RequestMapping(value="/log")
@RestController
public class LogController {
    private final LogControl logcontrol;

    public LogController(LogControl logcontrol) {
        this.logcontrol = logcontrol;
    }

    @PostMapping(value = "/set")
    public String setLogConf(HttpServletRequest httpRequest) {
        Map<String, String[]> ans = httpRequest.getParameterMap();
        ArrayList al = logcontrol.setConf(ans);
        if(al==null){
            return "参数设置成功";
        }else{
            return "重复参数："+al.toString();
        }
    }
}
