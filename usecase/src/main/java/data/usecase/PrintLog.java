package data.usecase;

import data.usecase.port.ILogGateways;
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
public class PrintLog {
    private ILogGateways iLogGateways;
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        List<String> l = iLogRepository.findConf(map.get("eventid")[0]);
        ArrayList<String> array = new ArrayList<String>();
        //array.add(map.get("eventid")[0]);
        for(String string:l){
            //String value = map.get(string)[0];
            if(map.get(string)==null){
                array.add("null");
            }else {
                array.add(map.get(string)[0]);
            }
        }
        iLogGateways.printLog(array);
    }
}
