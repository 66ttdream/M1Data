import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import data.entity.ArticleSummary;
import data.gateways.modle.ArticleSummaryGateways;
import data.gateways.modle.WxJsonGateways;
import org.junit.jupiter.api.Test;

public class GsonStringTest {
    @Test
    public void test(){
        String json = "[{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3},{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3}]";
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        for(int i=0; i< jsonArray.size(); i++){
                   JsonElement jsonElement = jsonArray.get(i);
            ArticleSummary  articleSummary=gson.fromJson(jsonElement,  ArticleSummary.class);
            System.out.println(articleSummary);

        }

        String json1 = "{ \n" +
                "    \"list\":[{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3},{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3}]}";
        WxJsonGateways user = gson.fromJson(json1, WxJsonGateways.class);
        ArticleSummaryGateways[] s = user.getList();
        for(ArticleSummaryGateways a:s){
            a.setAppid("1122");
            System.out.println(a+"11");
            System.out.print(a.getAppid()+"  "+a.getAddToFavCount());
        }
        System.out.println(user);
    }

}
