package InterFace;

import Utils.GetCookie;
import Utils.JsonParsing;
import Utils.PrintJsonString;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by changwingchit on 16/11/30.
 */

public class LoginRequest {

    public static String url = "XXXXXXXXXX";
    public static CookieStore cookieStore;

    public static void main(String args[]){
        //XXXX为敏感数据,在此不公布
        String jsonString;

        String loginUrl = "XXXXXXXXXXXXX";

        String userName = "XXXXXXXXXXXXX";

        String passWord = "XXXXXXXXXXX";

        jsonString = login(loginUrl,userName,passWord);

        JsonParsing.getJsonParsingString(jsonString,"message");

    }

    public static String login(String loginUrl,String userName,String passWord){

        String jsonString = null;

        HttpEntity httpEntity = null;

        GetCookie.getCookie(url);

        cookieStore = GetCookie.cookieStore;

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost(loginUrl);

        List<NameValuePair>params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("userName",userName));
        params.add(new BasicNameValuePair("passWord",passWord));

        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);

        httpPost.setEntity(uefEntity);

        CloseableHttpResponse httpResponse = null;

        try{
            PrintJsonString.printJson(httpClient,httpResponse,httpEntity,httpPost);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            httpResponse = httpClient.execute(httpPost);

            httpEntity = httpResponse.getEntity();

            jsonString = EntityUtils.toString(httpEntity);

        }catch (IOException e){
            e.printStackTrace();
        }

        return jsonString;
    }
}
