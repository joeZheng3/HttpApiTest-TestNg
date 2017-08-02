package InterFace;


import Utils.JsonParsing;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by changwingchit on 16/12/1.
 */
public class TimesRequest {

    //XXXX为敏感数据,在此不公布
    public static CookieStore cookieStore;
    public static String loginUrl = "XXXXXXXXXXXXXX";

    public static void main(String args[]){

        String timeUrl = "XXXXXXXXXXXXX";
        String userName = "XXXXXXXXXXX";
        String passWord = "XXXXXXXXXXXXXX";
        String jsonString = null;
        String youwant;

        jsonString = getTime(timeUrl,userName,passWord);

        youwant = JsonParsing.getJsonParsingString(jsonString,"err_msg");
        System.out.println(youwant);

    }

    public static String getTime(String timesUrl,String userName,String passWord)  {

        String jsonString = null;
        LoginRequest.login(loginUrl,userName,passWord);
        cookieStore = LoginRequest.cookieStore;
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(timesUrl);
        CloseableHttpResponse httpResponse = null;
        HttpEntity entityTime = null;

        try {
            Utils.PrintJsonString.printJson(httpClient,httpResponse,entityTime,httpPost);
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            httpResponse = httpClient.execute(httpPost);

            entityTime = httpResponse.getEntity();

            jsonString = EntityUtils.toString(entityTime);

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonString;
    }



}
