package data.usecase;

import data.entity.SynParameter;
import data.usecase.port.SynParmeterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimingCreateTask {
    private SynParmeterRepository synParmeterRepository;
    private TimingSaveData timingSaveData;
    /*public TimingCreateTask(SynParmeterRepository synParmeterRepository,TimingSaveData timingSaveData) {
        this.synParmeterRepository=synParmeterRepository;
        this.timingSaveData = timingSaveData;
    }*/

    public BlockingQueue execut(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(20000);
        List<SynParameter> list = synParmeterRepository.findAllParameter();
        for(SynParameter synParameter:list){
           TimingRunTask rt =  new TimingRunTask(synParameter,timingSaveData);
            blockingQueue.add(rt);
        }
        return blockingQueue;
    }

}
