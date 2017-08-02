package DataBase;

/**
 * Created by changwingchit on 16/12/2.
 */
public class UserVerifyTable {

    private int id;
    private int uid;
    private char mobile;
    private char email;
    private char verify;
    private int create_time;
    private int verify_time;
    private String ip;


    UserVerifyTable(int id, int uid, char mobile, char email, char verify, int create_time, int verify_time, String ip){
        this.id = id;
        this.uid = uid;
        this.mobile = mobile;
        this.email = email;
        this.verify = verify;
        this.create_time = create_time;
        this.verify_time = verify_time;
        this.ip = ip;
    }

    public String getId(){
        return String.valueOf(id);
    }

    public String getUid(){
        return  String.valueOf(uid);
    }

    public String getMobile(){
        return String.valueOf(mobile);
    }

    public String getEmail(){
        return String.valueOf(email);
    }

    public String getVerify(){
        return String.valueOf(verify);
    }

    public String getCreateTime(){
        return String.valueOf(create_time);
    }

    public String getVerifyTime(){
        return String.valueOf(verify_time);
    }

    public String getIp(){
        return ip;
    }

}
