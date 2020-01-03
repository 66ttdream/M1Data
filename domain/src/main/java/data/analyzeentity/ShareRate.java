package data.analyzeentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ShareRate {
    private String contentId;
    private  int viewNum;
    private int shareNum;
}
