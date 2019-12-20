package data.usecase;

import data.usecase.port.ILogGateways;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrintLog {
    private ILogGateways iLogGateways;
    public void execut(Map<String,String[]> map){
        iLogGateways.printLog(map);
    }
}
