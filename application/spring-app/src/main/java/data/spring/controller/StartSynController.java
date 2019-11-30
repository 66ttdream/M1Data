package data.spring.controller;



import data.controller.TimerSynDataControl;
import data.controller.modle.SynParameterWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StartSynController {

    private final TimerSynDataControl timerSynDataControl;

    @Autowired
    public StartSynController(final TimerSynDataControl timerSynDataControl) {
        this.timerSynDataControl = timerSynDataControl;
    }

    /*public StartSynController(final TimerSynData timerSynData) {
        this.timerSynData = timerSynData;
    }*/
    /*private final SynConfController scc;
    @Autowired
    public StartSynController(final SynConfController scc) {
        this.scc = scc;
    }*/

    @PostMapping(value = "/syn/start")
    public String synStart(@RequestBody SynParameterWeb synParameterWeb) {
        timerSynDataControl.start(synParameterWeb);
		return "successful";
    	
    }
    /*@PostMapping(value = "/synhistory/start")
    public String synHistoryData(@RequestBody SynHistoryDataWeb synHistoryDataWeb){

        return "successful";

    }*/
}
