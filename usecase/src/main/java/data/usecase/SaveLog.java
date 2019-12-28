package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLog {
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        List<String> l = iLogRepository.findConf(map.get("eventid")[0]);
        //System.out.println(l.get(0));
        Map m = new HashMap<String,String>();
        for(String str:l){
            if(map.get(str)==null){
                m.put(str, "null");
            }else {
                m.put(str, map.get(str)[0]);
            }
        }
        iLogRepository.upData(m);
    }
}
