package data.timingtask;

import data.TimingTask.conf.TimingTaskConfig;
import data.usecase.TimingCreateTask;
import data.usecase.TimingRunTask;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimingTask extends TimerTask {
    private BlockingQueue blockingQueue;
    private TimingCreateTask createTask;
    private TimingRunTask rt;
    @Override
    public void run() {
        var timingTaskConfig = new TimingTaskConfig();
        createTask = timingTaskConfig.TimingCreateTask();
        blockingQueue =createTask.execut();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000));
        executor.prestartAllCoreThreads();
        for(Object t:blockingQueue){
            rt = (TimingRunTask)t;
            executor.execute(rt);
        }
    }
}
