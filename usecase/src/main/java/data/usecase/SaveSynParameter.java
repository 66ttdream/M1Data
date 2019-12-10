package data.usecase;

import data.entity.SynParameter;
import data.usecase.exception.AccessTokenException;
import data.usecase.port.AccessTokenGet;
import data.usecase.port.SynParmeterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveSynParameter {
    private  AccessTokenGet accessTokenGet;
    private SynParmeterRepository synParmeterRepository;
    public void execute(SynParameter sp) throws AccessTokenException{
        if(accessTokenGet.get(sp)!=null&&synParmeterRepository.findParameter(sp)==null){
            synParmeterRepository.insertPerameter(sp);
        }
        if(accessTokenGet.get(sp)!=null&&!synParmeterRepository.findParameter(sp).equals(sp)){
            synParmeterRepository.upPerameter(sp);
        }
    }


}
