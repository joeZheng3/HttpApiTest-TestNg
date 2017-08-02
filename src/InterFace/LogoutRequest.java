package InterFace;

import Utils.PrintJsonString;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by changwingchit on 16/11/30.
 */
public class LogoutRequest {

    //XXXX为敏感数据,在此不公布
    public static CookieStore cookieStore;
    private static String loginUrl = "XXXXXXXXXXX";
    private static String userName = "XXXXXXXXXXX";
    private static String passWord = "XXXXXXXXXXX";

    public  static  void main(String args[]){
        //TODO
    }

    public static String logout(String logoutUrl){

        String jsonString = null;

        LoginRequest.login(loginUrl,userName,passWord);

        cookieStore = LoginRequest.cookieStore;

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost(logoutUrl);

        CloseableHttpResponse httpResponse = null;

        HttpEntity logoutEntity = null;

        try{
            PrintJsonString.printJson(httpClient,httpResponse,logoutEntity,httpPost);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {

            httpResponse = httpClient.execute(httpPost);

            HttpEntity httpEntity = httpResponse.getEntity();

            jsonString = EntityUtils.toString(httpEntity);

        }catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;

    }



}
