package data.usecase;

import data.entity.SynParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RunTask implements Runnable{
    private SynParameter synParameter;
    private SaveData saveData;
    public RunTask(SynParameter synParameter) {
        this.synParameter=synParameter;
    }

    @Override
    public void run() {
        saveData.execut(synParameter);
    }

}
