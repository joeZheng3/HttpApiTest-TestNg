package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by changwingchit on 16/11/30.
 */
public class JsonParsing {

  public static String getJsonParsingString(String jsonString,String youWant){

      String result;

      JSONObject jsonobj = JSON.parseObject(jsonString);

      result = jsonobj.getString(youWant);

      System.out.println(result);

      return result;
  }

}
