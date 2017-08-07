package test;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;

import java.sql.*;

public class SqlTest {

    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false","root","123456");

        String sql = "select count(*) from t_user where user_name=?";
        String[] columnNames = {"user_name"};
        PreparedStatement preparedStatement = connection.prepareStatement(sql,columnNames);
        preparedStatement.setString(1,"admin");

        ResultSet resultSet = preparedStatement.executeQuery();



    }
}
