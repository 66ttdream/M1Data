package data.usecase;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerRunSynTask {
    public void execute(){
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(20);
    }

}
