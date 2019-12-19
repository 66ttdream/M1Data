package data.controller;

import data.usecase.SaveLogConfig;

import java.util.ArrayList;
import java.util.Map;

public class LogControl {
    private SaveLogConfig saveLogConfig;
    public ArrayList setConf(Map<String , String[]> map){
        return saveLogConfig.execut(map);
    }
}
