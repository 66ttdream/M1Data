package data.usecase;

import data.usecase.port.SynParmeterRepository;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteSynParameter {
    private SynParmeterRepository synParmeterRepository;
    public void execut(AppId appid){
        synParmeterRepository.deletePerameter(appid);
    }
}
