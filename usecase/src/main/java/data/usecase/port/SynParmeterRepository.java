package data.usecase.port;

import data.entity.SynParameter;

public interface SynParmeterRepository {
    public SynParameter findParameter(SynParameter sp);
    public void insertPerameter(SynParameter sp);
    public void deletePerameter(SynParameter sp);
}
