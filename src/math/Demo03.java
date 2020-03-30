package math;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Demo03 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream resourceAsStream = Demo03.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}