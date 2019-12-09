package data.timingtask;

import data.TimingTask.conf.TimingTaskConfig;

import java.util.Date;
import java.util.Timer;

public class TimingTaskRunner {
    private static Timer timer=new Timer(true);
    private static TimingTask tasksControl =new TimingTask();
    public static void main(String[] args){
        timer.schedule(tasksControl,new Date(),86400000);
    }
}
