package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserRead {
    private AppId appid;
    private String refDate;
    private String intPageReadUser;
    private String intPageReadCount;
    private String oriPageReadUser;
    private String oriPageReadCount;
    private String shareUser;
    private String shareCount;
    private String addToFavUser;
    private String addToFavCount;
}
