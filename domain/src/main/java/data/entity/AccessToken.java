package data.entity;


import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Deprecated
public class AccessToken {
     private AppId accesstokenId;
     private String accesstoken;
}
