package data.controller.modle;

import data.vo.id.AppId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancleParameterWeb {
    private String appid;
    public AppId toAppid(String appid){
        return  new AppId(appid);
    }
}
