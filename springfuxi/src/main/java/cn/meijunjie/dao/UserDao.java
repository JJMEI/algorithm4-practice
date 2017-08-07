package cn.meijunjie.dao;

import cn.meijunjie.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;  //spring 提供的简化jdbc连接的末班

    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(*) from t_user where user_name=? and password=?";
        Object[] parameter = {userName,password};
        return jdbcTemplate.queryForObject(sqlStr, parameter, Integer.class);
    }



    //这里使用了匿名内部类
    public User findUserByUserName(final String userName)
    {
        String sqlStr = "select user_id,user_name,password from t_user where user_name=?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setPassword(resultSet.getString("password"));
            }
        });

        return user;
    }

    public void updateLoginInfo(User user)
    {
        String sqlStr = "update t_user set last_visit=?,last_ip=? where user_id=?";

        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(), user.getUserId()});
    }


}
