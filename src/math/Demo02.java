package math;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) {
        DataSource source = new ComboPooledDataSource("otherc3p0");
        Connection conn =null;
        PreparedStatement stmt =null;
        try {
            conn = source.getConnection();
            String sql = "insert into student values(null,'王石','pengze',18);";
            stmt = conn.prepareStatement(sql);
            int i = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn);
        }
    }
}
