package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLogConfig {
    private ILogRepository iLogRepository;
    public ArrayList execut(Map<String,String[]> map){
        List<String> l = iLogRepository.findConf(map.get("eventid")[0]);
        ArrayList al  = new ArrayList();
        int i=0;
        for(String str:l){
            if(map.get(str)!=null){
                al.add(str);
                i++;
            }
        }
        if(i==1){
            iLogRepository.insert(map);
        }
        return al;
    }

}
