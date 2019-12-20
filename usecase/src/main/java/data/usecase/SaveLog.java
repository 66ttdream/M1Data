package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLog {
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        iLogRepository.upData(map);
    }
}
