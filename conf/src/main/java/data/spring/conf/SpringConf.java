package data.spring.conf;

import data.gateways.tokengateways.AccessTokenGateways;
import data.repository.synparameter.SynPerameterRepository;
import data.usecase.DeleteSynParameter;
import data.usecase.SaveSynParameter;
import data.usecase.port.AccessTokenGet;
import data.usecase.port.SynParmeterRepository;

public class SpringConf {
    private final AccessTokenGet accessTokenGet = new AccessTokenGateways();
    private final SynParmeterRepository synParmeterRepository = new SynPerameterRepository();

    public SaveSynParameter saveSynParameter(){
        return  new SaveSynParameter(accessTokenGet,synParmeterRepository);
    }

    public DeleteSynParameter deleteSynParameter(){
        return  new DeleteSynParameter(synParmeterRepository);
    }



}
