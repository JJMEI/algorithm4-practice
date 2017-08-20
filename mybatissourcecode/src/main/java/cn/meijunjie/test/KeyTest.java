package cn.meijunjie.test;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class KeyTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //DriverManager.getConnection(url,username,password) 获取数据库连接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false","root","123456");

        //设置为非自动提交
        connection.setAutoCommit(false);

        //获取PrepareStatement从Connection中获取 Statement.RETURN_GENERATED_KEY
        PreparedStatement pstm = connection.prepareStatement("insert into user(username,password) values(?,?),(?,?),(?,?)", Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1,"meijunjixdsed");
        pstm.setString(2,"dsafasfssddf");

        pstm.setString(3,"meijunjidsxed");
        pstm.setString(4,"dsafasfsdf");

        pstm.setString(5,"meijdunjixed");
        pstm.setString(6,"dsafasdfsdf");

        pstm.addBatch();
        pstm.executeBatch();

        ResultSet rs = pstm.getGeneratedKeys();  //获取 自增主键
        while(rs.next())
        {
            Object value = rs.getObject(1);
            log.info(value.toString());
        }
        connection.commit();
        rs.close();
        pstm.close();
        connection.close();
    }

}
