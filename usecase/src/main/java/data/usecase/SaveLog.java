package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLog {
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        ArrayList<String> al = iLogRepository.findConf(map.get("eventid")[0]);
        Map m = new HashMap<String,String>();
        for(String str:al){
            m.put(str,map.get(str)[0]);
        }
        iLogRepository.upData(m);
    }
}
