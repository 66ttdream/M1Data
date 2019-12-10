package data.controller;

import data.usecase.TimingCreateTask;
import data.usecase.TimingRunTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TimerTask;
import java.util.concurrent.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class TasksControl extends TimerTask {
        private BlockingQueue blockingQueue;
        private TimingCreateTask createTask = new TimingCreateTask();
        /*public void cancelTask(){

        }*/
        /*public void main(String args[]){
                //需增加实现定时执行
                blockingQueue =createTask.execut();
                ScheduledExecutorService schedulePool= Executors.newScheduledThreadPool(10);
                for(Object t:blockingQueue){
                       RunTask rt = (RunTask)t;
                        schedulePool.schedule(rt,5, TimeUnit.SECONDS);
                        schedulePool.scheduleAtFixedRate(rt,0,1, TimeUnit.DAYS);
                        schedulePool.scheduleWithFixedDelay(rt,2,1,TimeUnit.DAYS);
                }

        }
*/
    @Override
    public void run() {
        blockingQueue =createTask.execut();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000));
        executor.prestartAllCoreThreads();
        for(Object t:blockingQueue){
            TimingRunTask rt = (TimingRunTask)t;
            executor.execute(rt);
        }

    }
}
