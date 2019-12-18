package data.spring.controller;

import data.controller.modle.Log;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping(value="/log")
@RestController
public class LogController {
    @GetMapping(value="/handle")
    public String handle(@RequestParam String userid,String time,String eventid){
        if(eventid=="1"){

        }
         System.out.println(userid);
         return "收到";
    }
    @GetMapping(value = "/gather")
    public void gather(HttpServletRequest httpRequest){
          /*if(eventid=="1"){
              Log l = (Log)m;
             System.out.println(l.getUserid());

          }*/
          /*if(httpRequest.getParameter("eventid")=="1"){
              System.out.println(httpRequest.getParameter("eventid"));
          }
          if(httpRequest.getParameter("eventid")=="2"){

          }*/
        //System.out.println(l.getUserid());
        Map<String, String[]> ans = httpRequest.getParameterMap();
        String s = httpRequest.getParameter("eventid");
        System.out.println(s);
    }
}
