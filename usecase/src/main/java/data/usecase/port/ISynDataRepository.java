package data.usecase.port;

public interface ISynDataRepository {
    public void insertArticleSummary();
    public void insertInterfaceSummary();
    public void insertInterfaceSummaryHour();
    public void insertUpstreamMsg();
    public void insertUpstreamMsgDist();
    public void insertUpstreamMsgDistMonth();
    public void insertUpstreamMsgDistWeek();
    public void insertUpstreamMsgHour();
    public void insertUpstreamMsgMonth();
    public void insertUpstreamMsgWee();
    public void insertUserCumulate();
    public void insertUserRead();
    public void insertUserReadHour();
    public void insertUserShare();
    public void insertUserShareHour();
    public void insertUserSummary();

}
