package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by changwingchit on 16/12/1.
 */
public class ConnectDataBase {

    public static String msg;

    public static void main(String args[]) {

        //sql连接
        Connection conn = null;

        Statement statement = null;

        ResultSet rs = null;

        String url = null;

        String user = null;

        String password = null;

        String sql = null;

        String sql2 = null;


        try {
            //加载mysq驱动
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("驱动加载错误");
            e.printStackTrace();
        }

        try {
            //XXXX为敏感数据,在此不公布
            url = "jdbc:mysql://192.168.1.67:3306/XXXX?user=XXXX&password=XXXXX";
            user = "XXXX";
            password = "XXXX";
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.out.println("数据库链接错误");
            e.printStackTrace();
        }

        try {
            //XXXX为敏感数据,在此不公布
            statement = conn.createStatement();
            sql = "SELECT a.verify FROM  (SELECT * FROM lzh_users_verify WHERE mobile = XXXXX ORDER BY create_time DESC LIMIT 1) a";
            rs = statement.executeQuery(sql);
            int col = rs.getMetaData().getColumnCount();

            //把查询到的数据转换成想要的形式
            System.out.println("============================");

            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }

            System.out.println("============================");

            msg = rs.toString();
            System.out.print(msg);

        } catch (SQLException e) {
            System.out.println("数据库操作错误");
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
