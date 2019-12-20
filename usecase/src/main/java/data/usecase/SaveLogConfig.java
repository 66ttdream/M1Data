package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLogConfig {
    private ILogRepository iLogRepository;
    public ArrayList execut(Map<String,String[]> map){
        Map m = iLogRepository.findConf(map.get("eventid")[0]);
        ArrayList al  = new ArrayList();
        int i=0;
        Iterator it = m.keySet().iterator();
        while(it.hasNext()){
            if(map.get(it.next())!=null){
                al.add(it.next());
                i++;
            }
        }
        if(i==0){
            iLogRepository.insert(map);
        }
        return al;
    }

}
