package data.usecase;

import data.usecase.port.ILogGateways;
import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrintLog {
    private ILogGateways iLogGateways;
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        List<String> list = iLogRepository.findConf(map.get("eventid")[0]);
        for(String string:list){
            if(map.get(string)==null){
                map.put(string,null);
            };
        }
        iLogGateways.printLog(map);
    }
}
