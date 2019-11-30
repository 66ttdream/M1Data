package data.gateways.modle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpstreamMsgGateways {
    private String appid;
    private String refDate;
    private String msgType;
    private String msgUser;
    private String msgCount;
}
