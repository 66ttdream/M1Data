package data.repository.model;

import data.analyzeentity.ShareRate;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IShareRate {
    @Column
    int contentId();
    @Column
    int viewNum();
    @Column
    int shareNum();
    public static ShareRate toDomain(IShareRate iShareRate){
        return ShareRate.builder()
                .shareNum(iShareRate.shareNum())
                .viewNum(iShareRate.viewNum())
                .contentId(ContentRepository.findContentById(iShareRate.contentId()))
                .build();
    }
}
