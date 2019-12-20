package data.usecase.port;

import java.util.Map;

public interface ILogGateways {
    public void printLog(Map<String,String[]> map);
}
