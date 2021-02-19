package Flag.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcutils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
        static {

            try{
                InputStream in = jdbcutils.class.getClassLoader().getResourceAsStream("lesson02/utils/db.properties");
                Properties properties = new Properties();
                properties.load(in);

                driver = properties.getProperty("driver");
                driver = properties.getProperty("url");
                driver = properties.getProperty("username");
                driver = properties.getProperty("password");

                //驱动只加载一次
                Class.forName(driver);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
                //获取连接
                public static Connection getConnection() throws SQLException {
                    return DriverManager.getConnection(url,username,password);
                }


                //释放连接资源
                public static void release(Connection conn, Statement st, ResultSet rs){
                    if (rs!=null){
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (st!=null){
                        try {
                            st.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (conn!=null){
                        try {

                                conn.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
}
