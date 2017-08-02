package InterFace;

import Utils.JsonParsing;
import Utils.PrintJsonString;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by changwingchit on 16/11/30.
 */
public class AwardUsersRequest {

    //XXXX为敏感数据,在此不公布
    //测试环境url
    public static String urlForAct = "http://192.168.1.67:8081/XXXXXXX/queryAwardUsersJson.json";

    //正式环境url
    public static String urlForAct1 = "http://XXXXXXXXXX/queryAwardUsersJson.json";

    public  static  void main(String args[]){

        String jsonString = awardUsersJsonRequest(urlForAct1);

        String msg = JsonParsing.getJsonParsingString(jsonString,"msg");

    }

    public static String awardUsersJsonRequest(String url)  {

        String jsonString = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        CloseableHttpResponse httpResponse = null;

        HttpEntity awardUesrEntity = null;

        try{
            PrintJsonString.printJson(httpClient,httpResponse,awardUesrEntity,httpPost);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            httpResponse = httpClient.execute(httpPost);

            awardUesrEntity = httpResponse.getEntity();

            jsonString = EntityUtils.toString(awardUesrEntity);
        }catch (IOException e){
            e.printStackTrace();
        }

        return jsonString;

    }

}
