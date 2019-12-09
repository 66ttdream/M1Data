module Data.gateways{
    exports data.gateways.tokengateways;
    exports data.gateways.datagateways;
    requires Data.usecase;
    requires weixin.java.mp;
    requires Data.domain;
    requires weixin.java.common;
    requires Data.infrastructure;
    requires lombok;
    requires gson;

}