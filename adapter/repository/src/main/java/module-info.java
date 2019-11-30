module Data.repository{
    exports data.repository.synparameter;
    requires Data.usecase;
    requires Data.domain;
    requires com.github.davidmoten.rxjava2.jdbc;
    requires com.github.davidmoten.rxjava2.pool;
    requires lombok;
    requires io.reactivex.rxjava2;
    requires log4j;

}