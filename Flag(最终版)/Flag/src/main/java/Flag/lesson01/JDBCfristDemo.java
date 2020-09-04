package Flag.lesson01;

import java.sql.*;

// 我的第一个JDBC程序
public class JDBCfristDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1、加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver"); //固定写法，加载驱动


        //2、用户信息和url
        //useUnicode=true   支持中文编码
        //& characterEncoding=utf8  设定中文字符集优先
        // & useSSL=ture    使用安全的连接
        String url = "jdbc:mysql://localhost:3306/升旗?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=TRUE";
        String username = "root";
        String password = "010412";

        //3、连接成功,数据库对象  Connection  代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4、执行sql语句 Statement   执行sql对象
        Statement statement = connection.createStatement();


        //5、z执行sql对象， 去 执行sql 可能存在结果，查看返回结果
//        String sql = "SELECT `id` FROM `students`" +
//                        "ORDER BY `id` ASC;" ;

        String sql = " SELECT COUNT(*) AS COUNT FROM  students;";


        ResultSet resultSet = statement.executeQuery(sql); //返回的结果集,结果集中封装了我们全部的查询出来的结果


        while(resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
        }

        //6、释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
