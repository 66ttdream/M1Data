package data.controller;

import data.controller.modle.SynParameterWeb;
import data.usecase.SaveSynParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class TimerSynDataControl {
    private SaveSynParameter saveSynParameter;
    public void start(SynParameterWeb spw){
        saveSynParameter.execute(spw.toSynParameter());
    }

}
