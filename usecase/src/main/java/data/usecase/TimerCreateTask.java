package data.usecase;

import data.entity.SynParameter;
import data.usecase.exception.AccessTokenException;
import data.usecase.port.AccessTokenGet;
import data.usecase.port.SynParmeterRepository;

import java.util.List;

public class TimerCreateTask implements Runnable {
    private AccessTokenGet accessTokenGet;
    private SynParmeterRepository synParmeterRepository;
    private volatile List<SynParameter> l = synParmeterRepository.findAllParameter();
    /*public void execute(SynParameter sp) throws AccessTokenException {
        accessTokenGet.get(sp);
    }*/

    @Override
    public void run( ) {
        if(l!=null){
            l.get(0);

            l.remove(0);

        }

    }
    public static void execut(SynParameter synParameter){

    }
}
