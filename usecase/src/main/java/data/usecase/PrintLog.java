package data.usecase;

import data.usecase.port.ILogGateways;
import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrintLog {
    private ILogGateways iLogGateways;
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        ArrayList<String> al = iLogRepository.findConf(map.get("eventid")[0]);
        ArrayList<String> array = new ArrayList<String>();
        //array.add(map.get("eventid")[0]);
        for(String string:al){
            array.add(map.get(string)[0]);
        }
        iLogGateways.printLog(array);
    }
}
