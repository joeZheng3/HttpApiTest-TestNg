package TestCase;

import InterFace.TimesRequest;
import Utils.JsonParsing;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by changwingchit on 16/12/1.
 */
public class TestTimes {

    private static String timesUrl = "http://XXXXXXXXXXXX/queryTimesJson.json";
    private static String userName;
    private static String passWord;
    private static String exp = "0";
    private static String exp1 = "success";
    private static String exp2 = "5";

    @Test(groups = {"TimesCase"})
    public void verifyTimeRight(){ //检查总次数是否正确

        System.out.println("测试用例:"+"检查分享活动账户可以抽奖总次数是否正确");
        String jsonString;
        String resultString;

        userName = "XXXXXX";
        passWord = "123456";

        jsonString = TimesRequest.getTime(timesUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"total_time");
        Assert.assertEquals(resultString,exp);
        System.out.println("期待值:"+exp+"   "+"返回值:"+resultString);
    }

    @Test(groups = {"TimeCase"})
    public void verifyTimeRequestSucc(){  //检查接口是否通的
        System.out.println("测试用例:"+"检查分享活动账户次数接口是否通的");
        String jsonString;
        String resultString;

        userName = "XXXXXX";
        passWord = "123456";

        jsonString = TimesRequest.getTime(timesUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"err_msg");
        Assert.assertEquals(resultString,exp1);
        System.out.println("期待值:"+exp1+"   "+"返回值:"+resultString);
    }

    @Test(groups = {"TimeCase"})
    public void verifyTimeDayTime(){ //检查一天能够投资的总次数是否相同
        System.out.println("测试用例:"+"检查分享活动账户一天能够投资的总次数是否正确");
        String jsonString;
        String resultString;

        userName = "XXXXXX";
        passWord = "123456";

        jsonString = TimesRequest.getTime(timesUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"day_time");
        Assert.assertEquals(resultString,exp2);
        System.out.println("期待值:"+exp2+"   "+"返回值:"+resultString);
    }

}
