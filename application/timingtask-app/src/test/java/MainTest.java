import data.timingtask.TestTimer;
import data.timingtask.TimingTask;
import org.junit.jupiter.api.Test;
import util.Time;

import java.util.Date;
import java.util.Timer;

public class MainTest {
   /* @Test
    public void testMain(){
        Timer timer=new Timer(true);
        TimingTask tasksControl =new TimingTask();
        System.out.println("定时器被创建");
        timer.schedule(tasksControl, Time.getTomorrowBegin(),86400000);
        System.out.println("执行完成");
    }*/
    @Test
    public void test(){
        Timer timer=new Timer(true);
        TestTimer testTimer = new TestTimer();
        timer.schedule(testTimer, new Date(),1000);
    }

}
