package math;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Dmeo01 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            //"jdbc:mysql://localhost:3306/db3", "root", "root"
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");*/
            conn = JDBCUtils.getConnection();
            String sql = "insert into student values(null,'李九','pengze',18);";
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }
}