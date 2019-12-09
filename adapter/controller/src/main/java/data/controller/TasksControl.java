package data.controller;

import data.usecase.CreateTask;
import data.usecase.RunTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TasksControl {
        private BlockingQueue blockingQueue;
        private CreateTask createTask;
        /*public void cancelTask(){

        }*/
        public void main(String args[]){
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
}
