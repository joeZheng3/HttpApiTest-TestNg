package TestCase;

import InterFace.AwardUsersRequest;
import Utils.JsonParsing;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by changwingchit on 16/12/1.
 */
public class TestAwardUesrs {
    //XXXX为敏感数据,在此不公布
    public static String awardUsersUrl = "http://XXXXXXXXXXXXX/queryAwardUsersJson.json";
    public static String exp = "SUCCESS";

    @Test(groups = {"awardUsersUrlCase"})
    public void verifyAwardUserSucc(){

        System.out.println("测试用例:"+"检查分享活动页面上显示中奖人数接口是否正常");

        String jsonString;
        String resultString;

        jsonString = AwardUsersRequest.awardUsersJsonRequest(awardUsersUrl);
        resultString = JsonParsing.getJsonParsingString(jsonString,"msg");

        System.out.println("期待值:"+exp+"   "+"返回值:"+resultString);

        Assert.assertEquals(resultString,exp);
    }

}
