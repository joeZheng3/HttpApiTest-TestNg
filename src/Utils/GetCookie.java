package Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
/**
 * Created by changwingchit on 16/11/30.
 */
public class GetCookie {

    public static CookieStore cookieStore;

    public static void getCookie(String url){

        cookieStore = new BasicCookieStore();

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = null;

        try{
            httpResponse = httpClient.execute(httpGet);

            System.out.println("request line:" + httpGet.getRequestLine());

            setCookieStore(httpResponse);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void setCookieStore(HttpResponse httpResponse) {
        System.out.println("----setCookieStore");
        cookieStore = new BasicCookieStore();

        String setCookie = httpResponse.getFirstHeader("Set-Cookie")
                .getValue();

        String JSESSIONID = setCookie.substring("JSESSIONID=".length(),
                setCookie.indexOf(";"));
        System.out.println("JSESSIONID:" + JSESSIONID);

        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID",
                JSESSIONID);
        cookie.setVersion(0);
        //正式环境
        cookie.setDomain("XXXXXXXXXXXX");
        cookie.setPath("/");

        //测试环境
//        cookie.setDomain("192.168.1.67:8081");
//        cookie.setPath("/XXX");

        cookieStore.addCookie(cookie);
        String cookieStore1 = cookieStore.toString();
        System.out.println(cookieStore1);
    }


}
