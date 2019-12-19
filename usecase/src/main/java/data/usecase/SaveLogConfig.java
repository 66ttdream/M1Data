package data.usecase;

import data.usecase.port.ILogRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SaveLogConfig {
    private ILogRepository iLogRepository;
    public ArrayList execut(Map<String,String[]> map){
        Map m = iLogRepository.findConf();
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
