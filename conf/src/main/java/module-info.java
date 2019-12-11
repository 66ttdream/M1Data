module Data.conf {
    exports data.spring.conf;
    exports data.TimingTask.conf;
    requires Data.gateways;
    requires Data.usecase;
    requires Data.repository;
    requires lombok;

}