package data.gateways.loggateways;

import data.usecase.port.ILogGateways;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class LogGateways implements ILogGateways {
    private static Logger logger = Logger.getLogger(LogGateways.class);
    @Override
    public void printLog(ArrayList<String> al) {
        StringBuffer sb = new StringBuffer();
        for(String str:al){
            sb.append(str);
            sb.append("|");
        }
        logger.info(sb);
    }
}
