package TestCase;

import Utils.JsonParsing;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by changwingchit on 16/12/1.
 */
public class TestLogout {

    public static String logoutUrl = "http://XXXXXXXXXXX/logout.json";
    public static String exp1 = "200";

    @Test(groups = {"LogoutCase"})
    public void logoutSucc(){

        System.out.println("测试用例:"+"验证登出接口是否正常");
        String jsonString;
        String resultString;

        jsonString = InterFace.LogoutRequest.logout(logoutUrl);
        resultString = JsonParsing.getJsonParsingString(jsonString,"code");
        Assert.assertEquals(resultString,exp1);
        System.out.println("期待值:"+exp1+"   "+"返回值:"+resultString);

    }

}
