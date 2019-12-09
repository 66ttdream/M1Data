package data.usecase;

import data.entity.ArticleSummary;
import data.entity.SynParameter;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;

public class SaveData {
    //private data.usecase.port.SynParmeterRepository synParmeterRepository;
    private IWxDataGateways iWxDataGateways;
    private data.usecase.port.ISynDataRepository iSynDataRepository;
    public void execut(SynParameter synParameter){
        iWxDataGateways.getArticleSummary(synParameter);
        for(ArticleSummary articleSummary:iWxDataGateways.getArticleSummary(synParameter)){
           // iSynDataRepository.insertArticleSummary(iWxDataGateways.getArticleSummary(articleSummary));
        }


    }
}
