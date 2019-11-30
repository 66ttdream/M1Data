package data.controller.modle;

import data.entity.SynHistoryDataParameter;
import data.vo.id.AppId;

import java.util.Date;

public class SynHistoryDataWeb {
    private String appid;
    private Date beginTime;
    private Date endTime;
    public SynHistoryDataParameter toSynHistoryDataParameter() {
        return SynHistoryDataParameter.builder()
                .appid(new AppId(appid))
                .beginTime(beginTime)
                .endTime(endTime)
                .build();

    }
}
