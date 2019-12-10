package data.TimingTask.conf;

import data.gateways.datagateways.WxDataGateways;
import data.repository.syndata.SynDataRepository;
import data.repository.synparameter.SynPerameterRepository;
import data.usecase.TimingCreateTask;
import data.usecase.TimingRunTask;
import data.usecase.TimingSaveData;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;

public class TimingTaskConfig {
    private SynParmeterRepository synParmeterRepository = new SynPerameterRepository();
    private IWxDataGateways iWxDataGateways = new WxDataGateways();
    private ISynDataRepository iSynDataRepository = new SynDataRepository();


    public TimingSaveData TimingSaveData(){
        return new TimingSaveData(iWxDataGateways,iSynDataRepository);
    }
    public TimingCreateTask TimingCreateTask(){
        return new TimingCreateTask(synParmeterRepository);
    }
    public TimingRunTask TimingRunTask(){
        return null;
    }

}
