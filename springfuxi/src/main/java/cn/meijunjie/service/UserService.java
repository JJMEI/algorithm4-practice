package cn.meijunjie.service;

import cn.meijunjie.dao.LoginLogDao;
import cn.meijunjie.dao.UserDao;
import cn.meijunjie.po.LoginLog;
import cn.meijunjie.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password)
    {
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount > 0;
    }




    public User findUserByUserName(String userName)
    {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user)
    {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        loginLogDao.insertLoginLog(loginLog);
    }
}
