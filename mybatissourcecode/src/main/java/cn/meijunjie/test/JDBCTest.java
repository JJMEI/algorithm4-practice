package cn.meijunjie.test;

import jdk.nashorn.internal.scripts.JD;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JDBCTest {

    public static List<Map<String,Object>> queryForList()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        try
        {
            //1.加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";
            String username = "root";
            String password = "123456";

            //注册驱动并获取连接
            connection = DriverManager.getConnection(url,username,password);
            //创建Statement对象，每个Statement对象对应一次数据库操作
            preparedStatement = connection.prepareStatement("select * from user where id = ?");
            //设置查询参数
            preparedStatement.setString(1,"1");
            //执行查询
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int num = resultSetMetaData.getColumnCount();

            //遍历结果集
            while(resultSet.next())
            {
                Map map = new HashMap();
                for(int i=0;i<num;i++)
                {
                    String columnName = resultSetMetaData.getColumnName(i+1);
                    map.put(columnName,resultSet.getString(columnName));
                }
                list.add(map);
            }


        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            log.info("Class 文件未找到.....");
        }catch (SQLException e)
        {
            e.printStackTrace();
            log.info("SQL异常不符合MySQL语法规范.....");
        }finally {
            try
            {
                if(resultSet != null)
                {
                    resultSet.close();
                    resultSet = null;
                }
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if(connection != null)
                {
                    connection.close();
                    connection = null;
                }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
            return list;

        }
    }

    public static void main(String[] args)
    {
        JDBCTest.queryForList();
    }
}
