package data.repository.model;

import data.repository.port.ISynParameterDb;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SynParameterDb{
    String appid;
    String secret;
    String token;
    String asekey;


}
