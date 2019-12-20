package data.gateways.loggateways;

import data.usecase.port.ILogGateways;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LogGateways implements ILogGateways {
    @Override
    public void printLog(Map<String, String[]> map) {
        Iterator it = map.keySet().iterator();
        List l = new ArrayList<String>();
        while(it.hasNext()){
            l.add(map.get(it.next())[0]);
        }
        System.out.println(l);
    }
}
