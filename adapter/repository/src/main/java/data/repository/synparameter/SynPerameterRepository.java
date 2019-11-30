package data.repository.synparameter;

import data.entity.SynParameter;
import data.repository.db.Databases;
import data.repository.port.ISynParameterDb;
import data.usecase.port.SynParmeterRepository;

import java.util.List;

public class SynPerameterRepository implements SynParmeterRepository {
    public SynParameter findParameter(SynParameter sp){
        var sql = "SELECT appid,secret,token,asekey FROM synparameter WHERE appid=?";
        ISynParameterDb iSynParameterDb =Databases.getDb()
                .select(sql)
                .parameter(sp.getSynParameterId().getAppId())
                .autoMap(ISynParameterDb.class)
                .blockingFirst()
                ;
        return  ISynParameterDb.toDomain(iSynParameterDb);
    }

    public List<SynParameter> findAllParameter(){
        var sql = "SELECT * FROM synparameter";
        Databases.getDb()
                .select(sql)
                ;

        return null;
    }



    public void insertPerameter(SynParameter sp){
                var sql = "INSERT INTO synparameter VAlUES(?,?,?,?)";
                Databases.getDb()
                        .update(sql)
                        .parameters(sp.getSynParameterId().getAppId(),sp.getSecret(),sp.getToken(),sp.getAesKey())
                        .complete()
                        .blockingAwait();
    }


    public void deletePerameter(SynParameter sp){
        var sql = "DELETE FROM synparameter WHERE appid=?";
        Databases.getDb()
                .update(sql)
                .parameter(sp.getSynParameterId().getAppId())
                .complete()
                .blockingAwait();
    }
}
