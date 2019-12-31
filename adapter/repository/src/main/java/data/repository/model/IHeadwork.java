package data.repository.model;

import data.analyzeentity.HeatworkOfUser;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IHeadwork {
    @Column
    int contentId();
    @Column
    int pv();
    public static HeatworkOfUser toDomain(IHeadwork iHeadwork){
        return HeatworkOfUser.builder()
                .contentName(ContentRepository.findContentById(iHeadwork.contentId()))
                .pageView(iHeadwork.pv())
                .build();
    }
}
