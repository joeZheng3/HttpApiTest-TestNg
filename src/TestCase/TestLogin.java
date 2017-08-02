package TestCase;

import java.io.IOException;

import InterFace.LoginRequest;
import Utils.JsonParsing;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by changwingchit on 16/12/1.
 */
public class TestLogin {

      //XXXX为敏感数据,在此不公布
      public static String userName = null;
      public static String passWord = null;
      public static String loginUrl = "http://XXXXXXXXXXXXX/login.json";
      public static String exp1 = "登录成功";
      public static String exp2 = "密码错误";
      public static String exp3 = "未知账户";

    @Test(groups = {"LoginCase"})  //验证登录成功
    public void loginSucc() throws IOException{

        System.out.println("测试用例:"+"验证登录成功");
        String jsonString;
        String resultString;

        userName = "XXXXXXXXXX";
        passWord = "XXXXXXXXXX";
        jsonString = LoginRequest.login(loginUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"message");
        Assert.assertEquals(resultString,exp1);
        System.out.println("期待值:"+exp1+"   "+"返回值:"+resultString);
    }

    @Test(groups = {"LoginCase"})  //验证密码错误提示正确
    public void verifyPassWordWrong() throws IOException{

        System.out.println("测试用例:"+"验证密码错误提示正确");
        String jsonString;
        String resultString;

        userName = "XXXXXXXXXXX";
        passWord = "XXXXXXXXXXX";
        jsonString = LoginRequest.login(loginUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"errorMsg");
        Assert.assertEquals(resultString,exp2);
        System.out.println("期待值:"+exp2+"   "+"返回值:"+resultString);

    }

    @Test(groups = {"LoginCase"}) //验证密码为空不能登录
    public void verifyPassWordNull() throws IOException{

        System.out.println("测试用例:"+"验证密码为空不能登录");
        String jsonString;
        String resultString;

        userName = "XXXXXXXXX";
        passWord = "XXXXXXXXX";
        jsonString = LoginRequest.login(loginUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"errorMsg");
        System.out.println("期待值:"+exp2+"   "+"返回值:"+resultString);
        Assert.assertEquals(resultString,exp2);
    }

    @Test(groups = {"LoginCase"}) //验证账号为空不能登录
    public void verifyUserNameNull() throws IOException{
        System.out.println("测试用例:"+"验证账号为空不能登录");
        String jsonString;
        String resultString;

        userName = "";
        passWord = "";
        jsonString = LoginRequest.login(loginUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"errorMsg");
        Assert.assertEquals(resultString,exp2);
        System.out.println("期待值:"+exp2+"   "+"返回值:"+resultString);
    }

    @Test(groups = {"LoginCase"}) //验证不存在于数据库的账号是否能够登录
    public void verifyUserNameExistent() throws IOException{
        System.out.println("测试用例:"+"验证不存在于数据库的账号是否能够登录");
        String jsonString;
        String resultString;

        userName = "XXXXXXXXXX";
        passWord = "";
        jsonString = LoginRequest.login(loginUrl,userName,passWord);
        resultString = JsonParsing.getJsonParsingString(jsonString,"errorMsg");
        Assert.assertEquals(resultString,exp3);
        System.out.println("期待值:"+exp3+"   "+"返回值:"+resultString);
    }

}
