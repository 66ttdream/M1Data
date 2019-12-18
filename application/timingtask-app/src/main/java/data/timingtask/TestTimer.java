package data.timingtask;

import java.util.TimerTask;

public class TestTimer extends TimerTask{

    @Override
    public void run() {
        System.out.println("我被执行了");
    }
}
