package data.usecase.port;

import java.util.Map;

public interface ILogRepository {
    public void insert(Map<String,String[]> map);
    public Map findConf(String eventid);
    public void upData(Map<String,String[]> map);
}
