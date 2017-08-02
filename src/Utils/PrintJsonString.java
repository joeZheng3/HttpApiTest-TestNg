package Utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by changwingchit on 16/12/1.
 */
public class PrintJsonString {

    public static void printJson(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse, HttpEntity httpEntity, HttpPost httpPost) throws IOException
    {
        try{

            httpResponse = httpClient.execute(httpPost);

            httpEntity  = httpResponse.getEntity();

            try{

                System.out.println(httpResponse.getStatusLine());

            }catch (Exception e){

                e.printStackTrace();

                System.out.println("网络请求失败");

            }

            if (httpEntity !=null){

                InputStream is = httpEntity.getContent();

                InputStreamReader im = new InputStreamReader(is, Consts.UTF_8);

                BufferedReader br = new BufferedReader(im);

                String bitsString;

                while ((bitsString = br.readLine())!=null){

                    System.out.println(bitsString);

                }

                is.close();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }
}

