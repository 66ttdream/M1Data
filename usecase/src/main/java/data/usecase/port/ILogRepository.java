package data.usecase.port;

import java.util.ArrayList;
import java.util.Map;

public interface ILogRepository {
    public void insert(Map<String,String[]> map);
    public ArrayList<String> findConf(String eventid);
    public void upData(Map<String,String> map);
}
