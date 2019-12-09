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
public class TimingCreateTask {
    private SynParmeterRepository synParmeterRepository;
    public TimingCreateTask(SynParmeterRepository synParmeterRepository) {
        this.synParmeterRepository=synParmeterRepository;
    }

    public BlockingQueue execut(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(20000);
        List<SynParameter> list = synParmeterRepository.findAllParameter();
        for(SynParameter synParameter:list){
           TimingRunTask rt =  new TimingRunTask(synParameter);
            blockingQueue.add(rt);
        }
        return blockingQueue;
    }

}
