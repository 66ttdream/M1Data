package data.usecase;

import data.entity.SynParameter;
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
    private List<SynParameter> list;
    private BlockingQueue blockingQueue = new ArrayBlockingQueue(200);
    public BlockingQueue execut(){
        for(SynParameter synParameter:list){
           Task t =  new Task(synParameter);
            blockingQueue.add(t);
        }

        return blockingQueue;
    }

}
