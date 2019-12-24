import data.repository.log.LogRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogRepositoryTest {
    //@Test
    public void insertTest(){
        LogRepository log = new LogRepository();
        Map<String,String[]> map  = new HashMap();
        String s[] = {"int"};
        map.put("nigai",s);
        //Iterator it = map.keySet().iterator();
        log.insert(map);
    }
    @Test
    public void findConfTest(){
        LogRepository log = new LogRepository();
        List<String> l = log.findConf("1");
        for(String s :l){
            System.out.println(s);
        }
    }

}
