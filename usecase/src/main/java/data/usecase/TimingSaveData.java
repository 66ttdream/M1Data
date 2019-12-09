package data.usecase;

import data.entity.ArticleSummary;
import data.entity.SynParameter;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimingSaveData {
    private IWxDataGateways iWxDataGateways;
    private ISynDataRepository iSynDataRepository;

    public void execut(SynParameter synParameter){
        iWxDataGateways.getArticleSummary(synParameter);
        for(ArticleSummary articleSummary:iWxDataGateways.getArticleSummary(synParameter)){
            iSynDataRepository.insertArticleSummary(articleSummary);
        }

    }
}
