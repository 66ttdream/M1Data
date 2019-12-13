package data.timingtask;


import util.Time;

import java.util.Timer;

public class TimingTaskRunner {
    private static Timer timer=new Timer(true);
    //private static TimingTask tasksControl =new TimingTask();
    public static void main(String[] args){
        TimingTask tasksControl =new TimingTask();
        timer.schedule(tasksControl, Time.getTomorrowBegin(),86400000);
    }
}
