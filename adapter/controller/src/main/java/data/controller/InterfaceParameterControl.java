package data.controller;

import data.controller.modle.SynParameterWeb;
import data.usecase.DeleteSynParameter;
import data.usecase.SaveSynParameter;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class InterfaceParameterControl {
    private SaveSynParameter saveSynParameter;
    private DeleteSynParameter deleteSynParameter;

    public void start(SynParameterWeb spw){
        saveSynParameter.execute(spw.toSynParameter());
    }

    public void cancel(SynParameterWeb spw){
        deleteSynParameter.execut(new AppId(spw.getAppid()));
    }

}
