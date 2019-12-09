import data.entity.UserSummary;
import data.repository.syndata.SynDataRepository;
import data.vo.id.AppId;
import org.junit.jupiter.api.Test;

public class SynDataRepositoryTest {
    @Test
    public void test(){
        SynDataRepository sdr = new SynDataRepository();
        UserSummary userSummary = new UserSummary(new AppId("2132141"),"321","2313","0","421");
        sdr.insertUserSummary(userSummary);

    }

}
