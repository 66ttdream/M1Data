package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpstreamMsgDistMonth {
    private AppId appid;
    private String refDate;
    private String countInterval;
    private String msgUser;
}
