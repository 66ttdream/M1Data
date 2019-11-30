package data.gateways.tokengateways;

import com.google.gson.Gson;
import data.entity.SynParameter;
import data.gateways.conf.WxConf;
import data.gateways.modle.UserSummaryGateways;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.impl.WxMpDataCubeServiceImpl;
import util.Time;

import java.util.ArrayList;

import java.util.List;

public class WxDataGateways {
    public static ArrayList get(SynParameter sp) throws WxErrorException {  //date需要工具类实现
        Gson gson = new Gson();
        var begindate = Time.generateSynTime();
        var enddate = Time.generateSynTime();
        ArrayList al = new ArrayList<Object>();
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        var ArticleSummary = wd.getArticleSummary(begindate,enddate);//获取图文群发每日数据
        al.add(ArticleSummary);
        var ArticleTotal = wd.getArticleTotal(begindate,enddate);//获取图文群发总数据
        al.add(ArticleTotal);
        var InterfaceSummary = wd.getInterfaceSummary(begindate,enddate);//获取接口分析数据
        al.add(InterfaceSummary);
        var InterfaceSummaryHour = wd.getInterfaceSummaryHour(begindate,enddate);//获取接口分析分时数据
        al.add(InterfaceSummaryHour);
        var UpstreamMsg = wd.getUpstreamMsg(begindate,enddate);//获取消息发送概况数据
        al.add(UpstreamMsg);
        var UpstreamMsgDist = wd.getUpstreamMsgDist(begindate,enddate);//获取消息发送分布数据
        al.add(UpstreamMsgDist);
        var UpstreamMsgDistMonth = wd.getUpstreamMsgDistMonth(begindate,enddate);//获取消息发送分布月数据
        al.add(UpstreamMsgDistMonth);
        var UpstreamMsgDistWeek = wd.getUpstreamMsgDistWeek(begindate,enddate);//获取消息发送分布周数据
        al.add(UpstreamMsgDistWeek);
        var UpstreamMsgHour = wd.getUpstreamMsgHour(begindate,enddate);//获取消息分送分时数据
        al.add(UpstreamMsgHour);
        var UpstreamMsgMonth = wd.getUpstreamMsgMonth(begindate,enddate);//获取消息发送月数据
        al.add(UpstreamMsgMonth);
        var UpstreamMsgWeek = wd.getUpstreamMsgWeek(begindate,enddate);//获取消息发送周数据
        al.add(UpstreamMsgWeek);
        var UserCumulate = wd.getUserCumulate(begindate,enddate);//获取累计用户数据
        al.add(UserCumulate);
        var UserRead = wd.getUserRead(begindate,enddate);//获取图文统计数据
        al.add(UserRead);
        var UserReadHour = wd.getUserReadHour(begindate,enddate);//获取图文统计分时数据
        al.add(UserReadHour);
        var UserShare = wd.getUserShare(begindate,enddate);//获取图文分享转发数据
        al.add(UserShare);
        var UserShareHour = wd.getUserShareHour(begindate,enddate);//获取图文分享转发分时数据
        al.add(UserShareHour);
        var UserSummary = wd.getUserSummary(begindate,enddate);//获取用户增减数据
        //UserSummaryGateways userSummaryGateways = gson.fromJson(wd.getUserSummary(begindate,enddate).toString().replace("[","").replace("]",""),UserSummaryGateways.class);
        al.add(UserSummary);
        return al;

    }

}
