package data.usecase;

import data.entity.SynParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimingRunTask implements Runnable{
    private SynParameter synParameter;
    private TimingSaveData timingSaveData;
    private Lock lock = new ReentrantLock();

    public TimingRunTask(SynParameter synParameter,TimingSaveData timingSaveData) {
        this.synParameter=synParameter;
        this.timingSaveData=timingSaveData;
    }

    @Override
    public void run() {
        lock.lock();
        timingSaveData.execut(synParameter);
        lock.unlock();
    }

}
