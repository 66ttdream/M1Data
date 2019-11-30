package data.usecase;

import data.entity.SynParameter;
import data.usecase.exception.AccessTokenException;
import data.usecase.port.AccessTokenGet;

public class TimerCreateTask {
    private AccessTokenGet accessTokenGet;
    public void execute(SynParameter sp) throws AccessTokenException {
        accessTokenGet.get(sp);
    }

}
