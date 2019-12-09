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
public class CreateTask {
    private SynParmeterRepository synParmeterRepository;
    private BlockingQueue blockingQueue = new ArrayBlockingQueue(20000);
    public BlockingQueue execut(){
        List<SynParameter> list = synParmeterRepository.findAllParameter();
        for(SynParameter synParameter:list){
           RunTask rt =  new RunTask(synParameter);
            blockingQueue.add(rt);
        }
        return blockingQueue;
    }
}
