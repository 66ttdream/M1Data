package data.usecase.validator;

import data.entity.SynParameter;
import data.usecase.port.AccessTokenGet;

public class ValidationParameter {
    private AccessTokenGet accessTokenGet;
    public void execute(SynParameter sp){
        accessTokenGet.get(sp);
    }
}
