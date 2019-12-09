package data.usecase.port;

import data.entity.*;

import java.util.List;

public interface IWxDataGateways {
    public List<ArticleSummary> getArticleSummary(SynParameter sp);
    public List<ArticleTotal> getArticleTotal(SynParameter sp);
    public List<InterfaceSummary> getInterfaceSummary(SynParameter sp);
    public List<InterfaceSummaryHour> getInterfaceSummaryHour(SynParameter sp);
    public List<UpstreamMsg> getUpstreamMsg(SynParameter sp);
    public List<UpstreamMsgDist> getUpstreamMsgDist(SynParameter sp);
    public List<UpstreamMsgDistMonth> getUpstreamMsgDistMonth(SynParameter sp);
    public List<UpstreamMsgDistWeek> getUpstreamMsgDistWeek(SynParameter sp);
    public List<UpstreamMsgHour> getUpstreamMsgHour(SynParameter sp);
    public List<UpstreamMsgMonth> getUpstreamMsgMonth(SynParameter sp);
    public List<UpstreamMsgWeek> getUpstreamMsgWeek(SynParameter sp);
    public List<UserCumulate> getUserCumulate(SynParameter sp);
    public List<UserRead> getUserRead(SynParameter sp);
    public List<UserReadHour> getUserReadHour(SynParameter sp);
    public List<UserShare> getUserShare(SynParameter sp);
    public List<UserShareHour> getUserShareHour(SynParameter sp);
    public List<UserSummary> getUserSummary(SynParameter sp);

}
