package Flag.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
   public static void insert(String yb_realname,String yb_userid){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;

       try {
           conn = jdbcutils.getConnection();   //获取数据库连接
           st = conn.createStatement();    //获取SQL对象
           String sql = "INSERT INTO students(`name`,`zhanghao`)" +
                   "VALUES(yb_realname,yb_userid)";
           int i = st.executeUpdate(sql);
           if(i>0){
               System.out.println("插入成功！");
           }else{
               System.out.println("插入失败！");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           jdbcutils.release(conn,st,rs);
       }









   }

}
